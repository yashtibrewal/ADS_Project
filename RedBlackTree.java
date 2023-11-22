
import java.util.*;

/**
 * This file contains all the functions related to the RedBlack Tree and all the
 * helper functions required for the same.
 */
public class RedBlackTree {

    private RedBlackTreeNode root;
    private int colorFlip;

    private List<Book> rangeSearchResult;

    public enum NodeColor {
        RED,
        BLACK;
    }

    public enum Direction {
        left,
        right
    }

    /**
     * Data structure to store the tree while printing the tree for helping figure
     * the inserts deletes etc.
     */
    Map<Integer, List<RedBlackTreeNode>> treeBFS;

    public RedBlackTreeNode getRoot() {
        return root;
    }

    /**
     * Relation categorization for insertion and 2 reds in a row problem
     */
    class RelationXYz {

        Direction X;
        Direction Y;
        RedBlackTreeNode.NodeColor z;
        boolean twoRedsInARow;

        RelationXYz(Direction X, Direction Y, RedBlackTreeNode.NodeColor z, boolean twoRedsInARow) {

            this.X = X;
            this.Y = Y;
            this.z = z;
            this.twoRedsInARow = twoRedsInARow;

        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof RelationXYz)) {
                return false;
            }
            RelationXYz relation = (RelationXYz) obj;
            if (this.X == relation.X && this.Y == relation.Y && this.z == relation.z) {
                return true;
            }
            return false;

        }

    }

    /**
     * Relation categorization for deletion of a black node.
     */
    class RelationXcn {
        Direction X; // child direction of nodeY w.r.t to nodePY.
        RedBlackTreeNode.NodeColor c; // color of the node v (other child of py which is y's parent)
        int n; // number of red children for nodeV
        RedBlackTreeNode nodeV;

        RelationXcn(Direction X, RedBlackTreeNode.NodeColor c, int n, RedBlackTreeNode v) {
            this.X = X;
            this.c = c;
            this.n = n;
            this.nodeV = v;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof RelationXcn)) {
                return false;
            }
            RelationXcn relation = (RelationXcn) obj;
            if (this.X == relation.X && this.c == relation.c && this.n == relation.n) {
                return true;
            }
            return false;

        }

    }

    RedBlackTree() {
        setRoot(new RedBlackTreeNode());
        colorFlip = 0;
    }

    /**
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * PUBLIC API
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     */

    public void insert(Book book) {
        if (book == null)
            return;
        /**
         * If the root is null, update root.
         */

        if (getRoot().isExternalLeafNode()) {
            insertRootNode(book);
            return;
        }
        /**
         * We need to traverse the tree like a binary tree
         * to find the right place for insersion.
         */

        /**
         * TODO: recheck if the node is correctly updated with it's parent too.
         */

        RedBlackTreeNode nodeP = new RedBlackTreeNode();
        nodeP.color = RedBlackTreeNode.NodeColor.RED;
        nodeP.book = book;

        RedBlackTreeNode nodePP = searchPlacementForP(nodeP);
        /**
         * Based on the relation we can check if the insertion is at level 2, if it is,
         * we can simply insert.
         */
        if (isInsertLevelTwo(nodePP)) {
            attachNode(getRoot(), nodeP);
        } else {

            attachNode(nodePP, nodeP);

            /**
             * After finding the P's PP we can classify into multiple cases for insertion.
             */
            RelationXYz relation = getRelationForInsertionNode(nodeP, nodePP);

            /**
             * If the insert is not at level 2, that means we have to check the relation
             * type for inserts as the insertions are at level 3 or below.
             */
            while (relation.twoRedsInARow) {

                // Case: Rotations
                if (relation.z == RedBlackTreeNode.NodeColor.BLACK) {
                    // Dealing with 2 reds in a row problem.

                    // Case LLb
                    if (relation.X == Direction.left && relation.Y == Direction.left) {

                        RedBlackTreeNode GP = nodePP.parent;
                        if (GP == getRoot()) { // means the rotation is hapening at level 3
                            setRoot(handleInsertCaseLLb(nodeP));
                        } else { // means the rotation is happening below level 3, hence it is safe to reference
                                 // GP's P
                            RedBlackTreeNode GPP = nodePP.parent.parent;
                            if (GPP.leftChild == nodePP.parent) {
                                GPP.leftChild = handleInsertCaseLLb(nodeP);
                            } else {
                                GPP.rightChild = handleInsertCaseLLb(nodeP);
                            }
                        }

                        return;
                    }
                    // Case LRb
                    else if (relation.X == Direction.left && relation.Y == Direction.right) {

                        RedBlackTreeNode GP = nodePP.parent;
                        if (GP == getRoot()) { // means the rotation is hapening at level 3
                            setRoot(handleInsertCaseLRb(nodeP));
                        } else { // means the rotation is happening below level 3, hence it is safe to reference
                                 // GP's P
                            RedBlackTreeNode GPP = GP.parent;
                            if (GPP.leftChild == nodePP.parent) {
                                GPP.leftChild = handleInsertCaseLRb(nodeP);
                            } else {
                                GPP.rightChild = handleInsertCaseLRb(nodeP);
                            }
                        }

                        return;

                    }
                    // Case RRb
                    else if (relation.X == Direction.right && relation.Y == Direction.right) {

                        RedBlackTreeNode GP = nodePP.parent;
                        if (GP == getRoot()) { // means the rotation is hapening at level 3
                            setRoot(handleInsertCaseRRb(nodeP));
                        } else { // means the rotation is happening below level 3, hence it is safe to reference
                                 // GP's P
                            RedBlackTreeNode GPP = nodePP.parent.parent;
                            if (GPP.leftChild == nodePP.parent) {
                                GPP.leftChild = handleInsertCaseRRb(nodeP);
                            } else {
                                GPP.rightChild = handleInsertCaseRRb(nodeP);
                            }
                        }

                        return;
                    }
                    // Case RLb
                    else {

                        RedBlackTreeNode GP = nodePP.parent;
                        if (GP == getRoot()) { // means the rotation is hapening at level 3
                            setRoot(handleInsertCaseRLb(nodeP));
                        } else { // means the rotation is happening below level 3, hence it is safe to reference
                                 // GP's P
                            RedBlackTreeNode GPP = GP.parent;
                            if (GPP.leftChild == nodePP.parent) {
                                GPP.leftChild = handleInsertCaseRLb(nodeP);
                            } else {
                                GPP.rightChild = handleInsertCaseRLb(nodeP);
                            }
                        }

                        return;
                    }
                }
                // Case: Color Flips Cases
                // Should be RedBlackTreeNode.NodeColor RED
                else {
                    // Case LLr LRr RRr RLr have the same code.
                    // We color flip, and move P, PP, GP up 2 levels.

                    /**
                     * Case, GP is the root.
                     * GP cannot be the root, since if it was a root, it would have been a black
                     * node
                     * and for this case to be true, we need the GP to be a red node.
                     */

                    // Case GP is not the root.

                    /**
                     * This can only happen when the tree root is on any level above the GP node.
                     */
                    // Call Color Flip
                    colorFlip(nodeP);
                    // Move up the P, PP and GP 2 levels up.
                    nodeP = nodeP.parent.parent;
                    nodePP = nodeP.parent;
                    if (nodePP == null) { // node P is the root node
                        nodeP.color = RedBlackTreeNode.NodeColor.BLACK;
                        return;
                    }
                    if (nodePP.parent == null) { // node PP is the root node
                        nodePP.color = RedBlackTreeNode.NodeColor.BLACK;
                        return;
                    }
                    // Update the relation
                    relation = getRelationForInsertionNode(nodeP, nodePP);
                }
            }

        }

    }

    public int getColorFlipCount() {
        return colorFlip;
    }

    /**
     * Helps to figure out were the node P should be placed.
     * 
     * @param nodeP
     * @return
     */
    public RedBlackTreeNode searchPlacementForP(RedBlackTreeNode nodeP) {

        /**
         * We keep going down the levels to see an empty space
         * for the node for insertion.
         * 
         * We stop when we reach a node which is an external node.
         */
        RedBlackTreeNode temp = getRoot();
        RedBlackTreeNode nodePP = temp;

        /**
         * Initialize the relation as of root.
         */

        while (!temp.isExternalLeafNode()) { // The code will enter for atleast 1 time, since if root was null, it would
                                             // have been handled before
            if (nodeP.book.getBookId() < temp.book.getBookId()) {
                // Go left

                nodePP = temp;
                temp = temp.leftChild;
            } else {
                // Go right

                nodePP = temp;
                temp = temp.rightChild;
            }
        }

        return nodePP;
    }

    /**
     * Helper function to get the nodes and thier levels in an hashmap.
     * 
     * @param node
     * @param level
     */
    public void traverseBFS(RedBlackTreeNode node, int level) {
        if (node != null) {
            if (this.treeBFS.containsKey(level)) {
                this.treeBFS.get(level).add(node);
            } else {
                this.treeBFS.put(level, new ArrayList<RedBlackTreeNode>());
                this.treeBFS.get(level).add(node);
            }
            traverseBFS(node.leftChild, level + 1);
            traverseBFS(node.rightChild, level + 1);
        }
    }

    public List<Integer> delete(int bookID) {

        RedBlackTreeNode node = searchNode(bookID);
        if (!node.isExternalLeafNode()) {
            List<Integer> ids = node.book.getReservationPatronIDs();
            delete(node);
            return ids;
        }
        return new ArrayList<>();
    }

    public List<Book> rangeSearch(int bookID1, int bookID2) {
        rangeSearchResult = new ArrayList<Book>();
        addToListWhileSearching(bookID1, bookID2, root);
        Collections.sort(rangeSearchResult, new BookComparator());
        return rangeSearchResult;
    }

    public Book search(int bookID) {

        // implementing a binary search
        RedBlackTreeNode temp = this.getRoot();

        while (temp != null) {
            if (temp.book != null) {
                if (temp.book.getBookId() == bookID) {
                    return temp.book;
                }
                if (temp.book.getBookId() < bookID) {
                    temp = temp.rightChild;
                } else {
                    temp = temp.leftChild;
                }
            } else { // reached an external node / failure node
                return null;
            }
        }

        return null;
    }

    /**
     * For converting to string implicity while printing
     */
    @Override
    public String toString() {

        // Clean and Traverse BFS and print.
        this.treeBFS = new HashMap<>();
        traverseBFS(getRoot(), 0);
        return this.treeBFS.toString();

    }

    /**
     * It is assumed that the books we are looking for the closest to is already
     * existing in the function
     * 
     * @param bookID
     * @return
     */
    public List<Book> findClosestBook(int bookID) {

        List<Book> books = new ArrayList<>();
        RedBlackTreeNode node = searchNode(bookID);
        if (node.isExternalLeafNode()) {
            return findClosestBookIfSearchNotFound(bookID);
        } else {
            books.add(node.book);
            return books;
        }
    }

    /**
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * INSERT Functionalities
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     */

    /**
     * Helper for insert
     * 
     * @param book
     */
    private void insertRootNode(Book book) {
        RedBlackTreeNode node = getRoot();
        node.color = RedBlackTreeNode.NodeColor.BLACK;
        node.book = book;
        node.leftChild = new RedBlackTreeNode(); // Assigning External Leaf Node to the left
        node.rightChild = new RedBlackTreeNode(); // Assigning External Leaf Node to the left
        node.leftChild.setParent(getRoot());
        node.rightChild.setParent(getRoot());
    }

    private void setRoot(RedBlackTreeNode node) {
        this.root = node;
    }

    /**
     * This does not count for a color flip operation taught in the class for
     * inserting and reaching a 2 red in a row situation.
     * 
     * @param nodeV
     */
    private void flipNodeColor(RedBlackTreeNode nodeV) {
        if (nodeV.isBlack()) {
            nodeV.color = RedBlackTreeNode.NodeColor.RED;
        } else {
            nodeV.color = RedBlackTreeNode.NodeColor.BLACK;
        }
    }

    /**
     * Returns positive integer if the integer is negative.
     * 
     * @param x
     * @return
     */
    private int nonNegative(int x) {
        if (x < 0) {
            return -1 * x;
        }
        return x;
    }

    /**
     * This function returns the positive difference between the bookid and the
     * book's bookid
     * 
     * @param bookID
     * @param book
     * @return
     */
    private int getDifference(int bookID, Book book) {

        return nonNegative(bookID - book.getBookId());

    }

    /**
     * To convert a node to leaf node.
     * 
     * @param node
     */
    private RedBlackTreeNode convertToLeafNode(RedBlackTreeNode node) {
        RedBlackTreeNode parent = node.parent;

        if (parent.leftChild == node && node.parent != null) {
            node = new RedBlackTreeNode();
            parent.leftChild = node;
        } else if (parent.rightChild == node && node.parent != null) {
            node = new RedBlackTreeNode();
            parent.rightChild = node;
        } else { // no need to use parent if it is null (node is root)
            node = new RedBlackTreeNode();
        }

        node.parent = parent;
        return node;
    }

    private void incrementColorFlip() {
        colorFlip++;
    }

    /**
     * Color Flip for insert.
     * 
     * @param nodeP
     * @return
     */
    private RedBlackTreeNode colorFlip(RedBlackTreeNode nodeP) {

        incrementColorFlip();

        // d is red or null
        // Case 1, where d is red
        /**
         * We flip d and PP to black, and GP to red
         */
        RedBlackTreeNode nodePP = nodeP.parent;
        RedBlackTreeNode nodeGP = nodePP.parent;

        nodeGP.color = RedBlackTreeNode.NodeColor.RED;
        nodeGP.leftChild.color = RedBlackTreeNode.NodeColor.BLACK;
        nodeGP.rightChild.color = RedBlackTreeNode.NodeColor.BLACK;

        return nodeGP;

    }

    private RedBlackTreeNode handleInsertCaseLLb(RedBlackTreeNode nodeP) {

        // node GP should not be null since we are inserting at levels more then 2.
        RedBlackTreeNode nodePP = nodeP.parent;
        RedBlackTreeNode nodeGP = nodePP.parent;

        // Updating the colors // TODO: Update color flips.
        nodeGP.color = RedBlackTreeNode.NodeColor.RED;
        nodePP.color = RedBlackTreeNode.NodeColor.BLACK;
        nodeP.color = RedBlackTreeNode.NodeColor.RED;

        // Updating the parents
        nodeP.parent = nodePP;
        nodePP.parent = nodeGP.parent;
        nodeGP.parent = nodePP;

        // Updating the children
        nodeGP.leftChild = nodePP.rightChild;
        nodePP.rightChild = nodeGP;

        // return the new root to update to the function caller
        return nodePP;

    }

    private RedBlackTreeNode handleInsertCaseRRb(RedBlackTreeNode nodeP) {

        // node GP should not be null since we are inserting at levels more then 2.
        RedBlackTreeNode nodePP = nodeP.parent;
        RedBlackTreeNode nodeGP = nodePP.parent;

        // Updating the colors TODO: Update color flips.
        nodeGP.color = RedBlackTreeNode.NodeColor.RED;
        nodePP.color = RedBlackTreeNode.NodeColor.BLACK;
        nodeP.color = RedBlackTreeNode.NodeColor.RED;

        // Updating the parents
        nodeP.parent = nodePP;
        nodePP.parent = nodeGP.parent;
        nodeGP.parent = nodePP;

        // Updating the children
        nodeGP.rightChild = nodePP.leftChild;
        nodePP.leftChild = nodeGP;

        // return the new root to update to the function caller
        return nodePP;

    }

    private RedBlackTreeNode handleInsertCaseLRb(RedBlackTreeNode nodeP) {

        // node GP should not be null since we are inserting at levels more then 2.
        RedBlackTreeNode nodePP = nodeP.parent;
        RedBlackTreeNode nodeGP = nodePP.parent;

        // Updating the colors TODO: Update color flips.
        nodeGP.color = RedBlackTreeNode.NodeColor.RED;
        nodePP.color = RedBlackTreeNode.NodeColor.RED;
        nodeP.color = RedBlackTreeNode.NodeColor.BLACK;

        // Updating the parents
        nodeP.parent = nodeGP.parent;
        nodePP.parent = nodeP;
        nodeGP.parent = nodeP;

        // Updating the children
        nodePP.rightChild = nodeP.leftChild;
        nodeGP.leftChild = nodeP.rightChild;
        nodeP.leftChild = nodePP;
        nodeP.rightChild = nodeGP;

        // return the new root to update to the function caller
        return nodeP;

    }

    private RedBlackTreeNode handleInsertCaseRLb(RedBlackTreeNode nodeP) {

        // node GP should not be null since we are inserting at levels more then 2.
        RedBlackTreeNode nodePP = nodeP.parent;
        RedBlackTreeNode nodeGP = nodePP.parent;

        // Updating the colors TODO: Update color flips.
        nodeGP.color = RedBlackTreeNode.NodeColor.RED;
        nodePP.color = RedBlackTreeNode.NodeColor.RED;
        nodeP.color = RedBlackTreeNode.NodeColor.BLACK;

        // Updating the parents
        nodeP.parent = nodeGP.parent;
        nodePP.parent = nodeP;
        nodeGP.parent = nodeP;

        // Updating the children
        nodePP.leftChild = nodeP.rightChild;
        nodeGP.rightChild = nodeP.leftChild;
        nodeP.leftChild = nodeGP;
        nodeP.rightChild = nodePP;

        // return the new root to update to the function caller
        return nodeP;

    }

    private void attachNode(RedBlackTreeNode parent, RedBlackTreeNode insertionNode) {
        if (insertionNode.book.getBookId() < parent.book.getBookId()) {
            attachNode(insertionNode, parent, Direction.left);
        } else {
            attachNode(insertionNode, parent, Direction.right);
        }
    }

    /**
     * Attaches the insertionNode to the direction of the parentNode
     * 
     * @param inserstionNode
     * @param parentNode
     * @param direction
     */
    private void attachNode(RedBlackTreeNode inserstionNode, RedBlackTreeNode parentNode, Direction direction) {

        if (direction == Direction.left) {
            inserstionNode.leftChild = parentNode.leftChild;
            inserstionNode.parent = parentNode;
            inserstionNode.rightChild = new RedBlackTreeNode();
            inserstionNode.rightChild.parent = inserstionNode;
            parentNode.leftChild = inserstionNode;
        } else {
            inserstionNode.rightChild = parentNode.rightChild;
            inserstionNode.parent = parentNode;
            inserstionNode.leftChild = new RedBlackTreeNode();
            inserstionNode.leftChild.parent = inserstionNode;
            parentNode.rightChild = inserstionNode;
        }

    }

    private boolean isInsertLevelTwo(RedBlackTreeNode PP) {
        /**
         * If the GP is same as PP, we know that we just have to insert the node as a
         * child to root.
         */
        return PP == getRoot();// this implies that the insertion is level 2.

    }

    private RelationXYz getRelationForInsertionNode(RedBlackTreeNode P, RedBlackTreeNode PP) {

        Direction X;
        Direction Y;
        RedBlackTreeNode.NodeColor z;

        /**
         * Checks if the node would be inserted on the left side or on the right.
         */
        if (P.book.getBookId() < PP.book.getBookId()) {
            Y = Direction.left;
        } else {
            Y = Direction.right;
        }

        /**
         * To check if the PP node was on the left or the right of GP
         */
        RedBlackTreeNode GP = PP.parent;
        if (GP != null) { // Dealing with insertion at level 3 or below.

            if (PP.parent.leftChild == PP) {
                X = Direction.left;

                if (GP.rightChild.isRed()) {
                    z = RedBlackTreeNode.NodeColor.RED;
                } else {
                    z = RedBlackTreeNode.NodeColor.BLACK;
                }
            } else {
                X = Direction.right;

                if (GP.leftChild.isRed()) {
                    z = RedBlackTreeNode.NodeColor.RED;
                } else {
                    z = RedBlackTreeNode.NodeColor.BLACK;
                }
            }

        } else {
            GP = PP;
            X = null;
            z = null;
        }
        boolean twoRedsInARow;
        if (PP.isRed() && P.isRed()) {
            twoRedsInARow = true;
        } else {
            twoRedsInARow = false;
        }
        RelationXYz relation = new RelationXYz(X, Y, z, twoRedsInARow);

        return relation;
    }

    /**
     * Helper function to get the degree of a node.
     * 
     * @param node
     * @return
     */
    private int getNodeDegree(RedBlackTreeNode node) {

        if (node == null ||
                node.leftChild == null && node.rightChild == null ||
                node.leftChild.isExternalLeafNode() && node.rightChild.isExternalLeafNode()) {
            return 0;
        }

        if (!node.leftChild.isExternalLeafNode() && node.rightChild.isExternalLeafNode() ||
                node.leftChild.isExternalLeafNode() && !node.rightChild.isExternalLeafNode()) {
            return 1;
        }

        return 2;

    }

    /**
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * DELETE Functionalities
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     */

    /**
     * Checks for the number of red child it contains.
     * ONLY checks at the level below it.
     * Helper for deletion.
     * 
     * @param node
     * @return
     */
    private int getNoOfRedChilds(RedBlackTreeNode node) {

        int count = 0;

        if (node != null) {
            if (node.leftChild != null) {
                if (node.leftChild.isRed()) {
                    count++;
                }
            }
            if (node.rightChild != null) {
                if (node.rightChild.isRed()) {
                    count++;
                }
            }
        }

        return count;

    }

    /**
     * Function which generates a relation for the nodeY for deletion functionality.
     * 
     * @param nodeY
     * @return
     */
    private RelationXcn getRelationForNodeY(RedBlackTreeNode nodeY) {

        Direction directionX;
        RedBlackTreeNode.NodeColor colorC;
        int redNodeCountN;
        RedBlackTreeNode nodePY = nodeY.parent;
        RedBlackTreeNode nodeV;
        if (nodeY.parent != null) {

            // Setting direction X
            if (nodeY.parent.rightChild == nodeY) {
                directionX = Direction.right;
            } else {
                directionX = Direction.left;
            }

            // Setting node V
            if (directionX == Direction.right) {
                nodeV = nodePY.leftChild;
            } else {
                nodeV = nodePY.rightChild;
            }

            if (nodeV.isBlack()) {
                colorC = RedBlackTreeNode.NodeColor.BLACK;
            } else {
                colorC = RedBlackTreeNode.NodeColor.RED;
            }

            redNodeCountN = getNoOfRedChilds(nodeV);

            RelationXcn relationXcn = new RelationXcn(directionX, colorC, redNodeCountN, nodeV);
            return relationXcn;

        } else {
            return null;

        }
    }

    /**
     * Internal delete function.
     * 
     * @param bookID
     * @return
     */

    private void delete(RedBlackTreeNode node) {

        /**
         * If the deletion is of a red node we just delete it, except when the degree is
         * 2.
         */
        if (node.isRed()) {

            switch (getNodeDegree(node)) {
                case 0:
                    handleDeleteRedNodeDegreeZero(node);
                    break;
                case 1:
                    // Technically this case is not possible.
                    handleDeleteRedNodeDegreeOne(node);
                    System.out.println("Tree INVALID STATE REACHED!!");
                    break;
                case 2:
                    handleDeleteRedNodeDegreeTwo(node);
                    break;
            }
        } else {
            /**
             * If the deletion is of a black node we need to cater to the situation w.r.t to
             * the cases
             */

            // delete the black node and get nodePY with the relation and balance the nodePY

            switch (getNodeDegree(node)) {
                case 0:
                    handleDeleteBlackNodeDegreeZero(node);
                    break;
                case 1:
                    handleDeleteBlackNodeDegreeOne(node);
                    break;
                case 2:
                    handleDeleteBlackNodeDegreeTwo(node);
                    break;
            }
        }

    }

    private void handleDeleteBlackNodeDegreeTwo(RedBlackTreeNode node) {

        /**
         * We need to get the largest element in the node's left subtree.
         * Replace it with root, and then delete the leaf node.
         */
        RedBlackTreeNode temp = node.leftChild;

        // Case where we do not have a right child of leftchild, but we have a leftchild
        // of leftchild.
        if (!temp.leftChild.isExternalLeafNode() && temp.rightChild.isExternalLeafNode()) {
            // Then we have to just shift the content up. // This case is only possible if
            // temp is black and it has a red left child

            node.book = new Book(temp.book);
            temp.book = new Book(temp.leftChild.book);
            temp.leftChild = new RedBlackTreeNode();
            temp.leftChild.parent = temp;

        } else {
            while (!temp.rightChild.isExternalLeafNode()) {
                temp = temp.rightChild;
            }
            // Replacing
            node.book = new Book(temp.book);
            if (temp.isRed()) {
                temp = convertToLeafNode(temp);
                return;
            } else {

                temp = convertToLeafNode(temp);
                /**
                 * Now the temp node is the Y node and the parent is the PY node.
                 * We need to balance at PY now.
                 */

                handleRebalanceAtNodeY(temp);
            }

        }

    }

    private void handleDeleteBlackNodeDegreeOne(RedBlackTreeNode deletionNode) {

        if (deletionNode.parent == null) { // node is the root
            if (deletionNode.leftChild.isExternalLeafNode()) {
                deletionNode = deletionNode.rightChild;
            } else {
                deletionNode = deletionNode.leftChild;
            }
            flipNodeColor(deletionNode);
            deletionNode.rightChild = new RedBlackTreeNode();
            deletionNode.leftChild = new RedBlackTreeNode();
            deletionNode.rightChild.parent = deletionNode;
            deletionNode.leftChild.parent = deletionNode;
            return;
        }
        RedBlackTreeNode nodePY = deletionNode.parent;
        RedBlackTreeNode nodeY;
        if (deletionNode.parent.leftChild == deletionNode) {
            if (deletionNode.leftChild.isExternalLeafNode()) {
                nodeY = deletionNode.rightChild;
                nodeY.parent = nodePY;
                nodePY.leftChild = nodeY;
            } else {
                nodeY = deletionNode.leftChild;
                nodeY.parent = nodePY;
                nodePY.leftChild = nodeY;
            }
        } else {
            if (deletionNode.leftChild.isExternalLeafNode()) {
                nodeY = deletionNode.rightChild;
                nodeY.parent = nodePY;
                nodePY.rightChild = nodeY;
            } else {
                nodeY = deletionNode.leftChild;
                nodeY.parent = nodePY;
                nodePY.rightChild = nodeY;
            }
        }

        handleRebalanceAtNodeY(nodeY);

    }

    private void handleDeleteBlackNodeDegreeZero(RedBlackTreeNode node) {

        if (node.parent == null) { // root node
            node = new RedBlackTreeNode();
            setRoot(node);
            return;
        }

        RedBlackTreeNode nodePY = node.parent;
        if (node.parent.leftChild == node) {
            nodePY.leftChild = new RedBlackTreeNode();
            nodePY.leftChild.parent = nodePY;
            handleRebalanceAtNodeY(nodePY.leftChild);
        } else {
            nodePY.rightChild = new RedBlackTreeNode();
            nodePY.rightChild.parent = nodePY;
            handleRebalanceAtNodeY(nodePY.rightChild);
        }

    }

    private void handleRebalanceAtNodeY(RedBlackTreeNode nodeY) {

        if (nodeY == null || nodeY.parent == null) {
            // Reached the root node.
            return;
        }
        /**
         * We get the relation of Xcn where X is the direction to which nodeY exists to
         * nodePY
         * Pointer to the other node v (which is not a leaf node) is black, so c=black
         * n is the number of red children v has, i.e. 0,1 or 2.
         */
        RelationXcn relationXcn = getRelationForNodeY(nodeY);

        // When nodeY is on the right
        if (relationXcn.X == Direction.right) {
            // When nodeV is BLACK
            if (relationXcn.c == RedBlackTreeNode.NodeColor.BLACK) {

                // Rb0 CASE 1 when PY is black
                if (relationXcn.n == 0
                        && nodeY.parent.isBlack()) {
                    handleNodeDeletionCaseOneRb0(relationXcn.nodeV);
                    handleRebalanceAtNodeY(nodeY.parent); // Now nodePY is the root of deficiency nodeY
                }
                // Rb0 CASE 2 when PY is RED
                else if (relationXcn.n == 0
                        && nodeY.parent.isRed()) {
                    handleNodeDeletionCaseTwoRb0(relationXcn.nodeV);
                    // Deficiency is solved here so NO need to propogate up.
                }

                // Rb1 CASE 1 when left child of v is RED
                else if (relationXcn.n == 1
                        && relationXcn.nodeV.leftChild.isRed()) {
                    handleNodeDeletionCaseOneRb1(relationXcn.nodeV);
                    // Deficiency is solved here so NO need to propogate up.
                }

                // Rb1 CASE 1 when right child of v is RED
                else if (relationXcn.n == 1
                        && relationXcn.nodeV.rightChild.isRed()) {
                    handleNodeDeletionCaseTwoRb1(relationXcn.nodeV);
                }

                // Rb2 when both children are red
                else if (relationXcn.n == 2) {
                    handleNodeDeletionCaseTwoRb2(relationXcn.nodeV);
                }
            }
            // Where nodeV is red
            else {
                int redChildrenOfV = getNoOfRedChilds(relationXcn.nodeV.rightChild);
                switch (redChildrenOfV) {
                    case 0:
                        handleNodeDeletionRr0(relationXcn.nodeV);
                        break;

                    case 1:
                        RedBlackTreeNode nodeW = relationXcn.nodeV.rightChild;
                        if (nodeW.leftChild.isRed()) {
                            handleNodeDeletionCaseOneRr1(relationXcn.nodeV);
                        } else {
                            handleNodeDeletionCaseTwoRr1(relationXcn.nodeV);
                        }
                        break;

                    case 2:
                        handleNodeDeletionCaseRr2(relationXcn.nodeV);
                        break;
                }
            }
        }
        // When nodeY is on the left
        else {
            // When nodeV is BLACK
            if (relationXcn.c == RedBlackTreeNode.NodeColor.BLACK) {

                // Lb0 CASE 1 when PY is black
                if (relationXcn.n == 0
                        && nodeY.parent.isBlack()) {
                    handleNodeDeletionCaseOneLb0(relationXcn.nodeV);
                    handleRebalanceAtNodeY(nodeY.parent); // Now nodePY is the root of deficiency nodeY
                }

                // Lb0 CASE 2 when PY is RED
                else if (relationXcn.n == 0
                        && nodeY.parent.isRed()) {
                    handleNodeDeletionCaseTwoLb0(relationXcn.nodeV);
                    // Deficiency is solved here so NO need to propogate up.
                }

                // Lb1 CASE 1 when left child of v is RED
                else if (relationXcn.n == 1
                        && relationXcn.nodeV.leftChild.isRed()) {
                    handleNodeDeletionCaseTwoLb1(relationXcn.nodeV);
                    // Deficiency is solved here so NO need to propogate up.
                }

                // Lb1 CASE 1 when right child of v is RED
                else if (relationXcn.n == 1
                        && relationXcn.nodeV.rightChild.isRed()) {
                    handleNodeDeletionCaseOneLb1(relationXcn.nodeV);
                }

                // Rb1 CASE 1 when right child of v is RED
                else if (relationXcn.n == 2) {
                    handleNodeDeletionCaseTwoLb2(relationXcn.nodeV);
                }
            }
            // Where nodeV is red
            else {
                int redChildrenOfV = getNoOfRedChilds(relationXcn.nodeV.rightChild);
                switch (redChildrenOfV) {
                    case 0:
                        handleNodeDeletionLr0(relationXcn.nodeV);
                        break;

                    case 1:
                        RedBlackTreeNode nodeW = relationXcn.nodeV.rightChild;
                        if (nodeW.rightChild.isRed()) {
                            handleNodeDeletionCaseOneLr1(relationXcn.nodeV);
                        } else {
                            handleNodeDeletionCaseTwoLr1(relationXcn.nodeV);
                        }
                        break;

                    case 2:
                        handleNodeDeletionCaseLr2(relationXcn.nodeV);
                        break;
                }
            }
        }

    }

    private void handleNodeDeletionCaseLr2(RedBlackTreeNode nodeV) {

        // The logic is same for handleNodeDeletionCaseTwoRr1
        handleNodeDeletionCaseTwoLr1(nodeV);
    }

    private void handleNodeDeletionCaseTwoLr1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeW = nodeV.leftChild;
        RedBlackTreeNode nodeC = nodeW.leftChild;
        RedBlackTreeNode nodeX = nodeW.leftChild;
        RedBlackTreeNode nodeD = nodeX.leftChild;

        // Setting colors
        flipNodeColor(nodeX);

        // Setting parents
        nodeX.parent = nodePY.parent;
        nodePY.parent = nodeX;
        nodeC.parent = nodeW;
        nodeD.parent = nodePY;

        // Setting childrens
        nodeX.rightChild = nodeV;
        nodeX.leftChild = nodePY;
        nodePY.rightChild = nodeD;
        nodeW.leftChild = nodeC;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeX;
            } else {
                originalnodePYParent.rightChild = nodeX;
            }
        } else { // original nodePY was root
            setRoot(nodeX);
        }

    }

    private void handleNodeDeletionCaseOneLr1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeW = nodeV.leftChild;
        RedBlackTreeNode nodeC = nodeW.leftChild;
        RedBlackTreeNode nodeB = nodeW.rightChild;

        // Setting colors
        flipNodeColor(nodeB);

        // Setting parents
        nodeW.parent = nodePY.parent;
        nodePY.parent = nodeW;
        nodeB.parent = nodeV;
        nodeC.parent = nodePY;

        // Setting childrens
        nodeW.rightChild = nodeV;
        nodeV.leftChild = nodeB;
        nodePY.rightChild = nodeC;
        nodeW.leftChild = nodePY;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeW;
            } else {
                originalnodePYParent.rightChild = nodeW;
            }
        } else { // original nodePY was root
            setRoot(nodeW);
        }

    }

    private void handleNodeDeletionLr0(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeB = nodeV.leftChild;

        // Setting colors
        flipNodeColor(nodeV);
        flipNodeColor(nodeB);

        // Setting Parents
        nodeV = nodePY.parent;
        nodeB.parent = nodePY;

        // Setting Children
        nodeV.leftChild = nodePY;
        nodePY.rightChild = nodeB;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeV;
            } else {
                originalnodePYParent.rightChild = nodeV;
            }
        } else { // original nodePY was root
            setRoot(nodeV);
        }

    }

    private void handleNodeDeletionCaseTwoLb2(RedBlackTreeNode nodeV) {

        // Logic is same as Lb1 CaseTwo
        handleNodeDeletionCaseTwoLb1(nodeV);
    }

    private void handleNodeDeletionCaseTwoLb1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeW = nodeV.leftChild;
        RedBlackTreeNode nodeB = nodeV.leftChild.rightChild;
        RedBlackTreeNode nodeC = nodeV.leftChild.leftChild;

        // Setting colors
        if (nodePY.isBlack()) {
            nodeW.color = RedBlackTreeNode.NodeColor.BLACK;
        }
        nodePY.color = RedBlackTreeNode.NodeColor.BLACK;

        // Setting parents
        nodeW.parent = nodePY.parent;
        nodePY.parent = nodeW;
        nodeB.parent = nodeV;
        nodeC.parent = nodePY;

        // Setting children
        nodeV.leftChild = nodeB;
        nodePY.rightChild = nodeC;
        nodeW.rightChild = nodeV;
        nodeW.leftChild = nodePY;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeW;
            } else {
                originalnodePYParent.rightChild = nodeW;
            }
        } else { // original nodePY was root
            setRoot(nodeW);
        }

    }

    private void handleNodeDeletionCaseOneLb1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;

        // Rotation logic
        RedBlackTreeNode.NodeColor parentColor = nodePY.color;

        // Setting colors
        flipNodeColor(nodeV.rightChild);

        nodeV.color = parentColor;
        nodePY.color = RedBlackTreeNode.NodeColor.BLACK;

        // Setting parents
        nodeV.parent = nodePY.parent;
        nodePY.parent = nodeV;
        nodeV.leftChild.parent = nodePY;

        // Setting children
        nodePY.rightChild = nodeV.leftChild;
        nodeV.leftChild = nodePY;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeV;
            } else {
                originalnodePYParent.rightChild = nodeV;
            }
        } else { // original nodePY was root
            setRoot(nodeV);
        }

    }

    private void handleNodeDeletionCaseTwoLb0(RedBlackTreeNode nodeV) {
        flipNodeColor(nodeV);
        flipNodeColor(nodeV.parent);
    }

    private void handleNodeDeletionCaseOneLb0(RedBlackTreeNode nodeV) {
        // we just change the node V to Red.
        flipNodeColor(nodeV);
    }

    private void handleNodeDeletionCaseRr2(RedBlackTreeNode nodeV) {
        // The logic is same for handleNodeDeletionCaseTwoRr1
        handleNodeDeletionCaseTwoRr1(nodeV);
    }

    private void handleNodeDeletionCaseTwoRr1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeW = nodeV.rightChild;
        RedBlackTreeNode nodeC = nodeW.rightChild;
        RedBlackTreeNode nodeX = nodeW.rightChild;
        RedBlackTreeNode nodeD = nodeX.rightChild;

        // Setting colors
        flipNodeColor(nodeX);

        // Setting parents
        nodeX.parent = nodePY.parent;
        nodePY.parent = nodeX;
        nodeC.parent = nodeW;
        nodeD.parent = nodePY;

        // Setting childrens
        nodeX.leftChild = nodeV;
        nodeX.rightChild = nodePY;
        nodePY.leftChild = nodeD;
        nodeW.rightChild = nodeC;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeW;
            } else {
                originalnodePYParent.rightChild = nodeW;
            }
        } else { // original nodePY was root
            setRoot(nodeW);
        }

    }

    private void handleNodeDeletionCaseOneRr1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeW = nodeV.rightChild;
        RedBlackTreeNode nodeC = nodeW.rightChild;
        RedBlackTreeNode nodeB = nodeW.leftChild;

        // Setting colors
        flipNodeColor(nodeB);

        // Setting parents
        nodeW.parent = nodePY.parent;
        nodePY.parent = nodeW;
        nodeB.parent = nodeV;
        nodeC.parent = nodePY;

        // Setting childrens
        nodeW.leftChild = nodeV;
        nodeV.rightChild = nodeB;
        nodePY.leftChild = nodeC;
        nodeW.rightChild = nodePY;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeW;
            } else {
                originalnodePYParent.rightChild = nodeW;
            }
        } else { // original nodePY was root
            setRoot(nodeW);
        }

    }

    private void handleNodeDeletionRr0(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeB = nodeV.rightChild;

        // Setting colors
        flipNodeColor(nodeV);
        flipNodeColor(nodeB);

        // Setting Parents
        nodeV = nodePY.parent;
        nodeB.parent = nodePY;

        // Setting Children
        nodeV.rightChild = nodePY;
        nodePY.leftChild = nodeB;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeV;
            } else {
                originalnodePYParent.rightChild = nodeV;
            }
        } else { // original nodePY was root
            setRoot(nodeV);
        }
    }

    private void handleNodeDeletionCaseTwoRb2(RedBlackTreeNode nodeV) {

        // Logic is same as handleCaseTwoRb1
        handleNodeDeletionCaseTwoRb1(nodeV);

    }

    /**
     * The left node of nodePY is the nodeV and its left node is RED
     * 
     * @param nodeV
     */
    private void handleNodeDeletionCaseTwoRb1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;
        RedBlackTreeNode nodeW = nodeV.rightChild;
        RedBlackTreeNode nodeB = nodeV.rightChild.leftChild;
        RedBlackTreeNode nodeC = nodeV.rightChild.rightChild;

        // Setting colors
        if (nodePY.isBlack()) {
            nodeW.color = RedBlackTreeNode.NodeColor.BLACK;
        }
        nodePY.color = RedBlackTreeNode.NodeColor.BLACK;
        // Setting parents
        nodeW.parent = nodePY.parent;
        nodePY.parent = nodeW;
        nodeB.parent = nodeV;
        nodeC.parent = nodePY;

        // Setting children
        nodeV.rightChild = nodeB;
        nodePY.leftChild = nodeC;
        nodeW.leftChild = nodeV;
        nodeW.rightChild = nodePY;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeW;
            } else {
                originalnodePYParent.rightChild = nodeW;
            }
        } else { // original nodePY was root
            setRoot(nodeW);
        }

    }

    /**
     * The left node of nodePY is the nodeV and its left node is RED
     * 
     * @param nodeV
     */
    private void handleNodeDeletionCaseOneRb1(RedBlackTreeNode nodeV) {

        RedBlackTreeNode originalnodePYParent = nodeV.parent.parent;
        RedBlackTreeNode nodePY = nodeV.parent;

        // Rotation logic
        RedBlackTreeNode.NodeColor parentColor = nodePY.color;

        // Setting colors
        flipNodeColor(nodeV.leftChild);

        nodeV.color = parentColor;
        nodePY.color = RedBlackTreeNode.NodeColor.BLACK;

        // Setting parents
        nodeV.parent = nodePY.parent;
        nodePY.parent = nodeV;
        nodeV.rightChild.parent = nodePY;

        // Setting children
        nodePY.leftChild = nodeV.rightChild;
        nodeV.rightChild = nodePY;

        if (originalnodePYParent != null) {
            if (originalnodePYParent.leftChild == nodePY) {
                originalnodePYParent.leftChild = nodeV;
            } else {
                originalnodePYParent.rightChild = nodeV;
            }
        } else { // original nodePY was root
            setRoot(nodeV);
        }

    }

    /**
     * Handles the Case where the PY is is RED, y is black, and v is black
     * 
     * @param nodeV
     */
    private void handleNodeDeletionCaseTwoRb0(RedBlackTreeNode nodeV) {

        flipNodeColor(nodeV);
        flipNodeColor(nodeV.parent);

    }

    /*
     * Handles the deletion for the case Rb0
     */
    private void handleNodeDeletionCaseOneRb0(RedBlackTreeNode nodeV) {
        // we just change the node V to Red.
        flipNodeColor(nodeV);
    }

    /**
     * 
     * @param node
     */
    private void handleDeleteRedNodeDegreeZero(RedBlackTreeNode node) {

        // CASE if PY does not exist, then the whole tree is deficient, implying the
        // node is actually root.
        if (node.parent == null) {
            // Make the tree empty by just setting root to external node.
            setRoot(new RedBlackTreeNode());
        } else {
            // if the node is not the root.
            // If the node is red, we just delete it
            RedBlackTreeNode nodePY = node.parent;
            if (node.parent.leftChild == node) {
                // if the node is the left child
                nodePY.leftChild = new RedBlackTreeNode();
                nodePY.leftChild.parent = nodePY;
            } else {
                // if the node is the right child
                nodePY.rightChild = new RedBlackTreeNode();
                nodePY.rightChild.parent = nodePY;
            }
        }

    }

    /**
     * Degree two nodes are actually not deleted.
     * 
     * @param node
     */
    private void handleDeleteRedNodeDegreeTwo(RedBlackTreeNode node) {

        /**
         * We need to get the largest element in the node's left subtree.
         * Replace it with root, and then delete the leaf node.
         */
        RedBlackTreeNode temp = node.leftChild;

        // Case where we do not have a right child of leftchild, but we have a leftchild
        // of leftchild.
        if (!temp.leftChild.isExternalLeafNode() && temp.rightChild.isExternalLeafNode()) {
            // Then we have to just shift the content up.

            node.book = new Book(temp.book);
            temp.book = new Book(temp.leftChild.book);
            temp.leftChild = new RedBlackTreeNode();
            temp.leftChild.parent = temp;

        } else {

            while (!temp.rightChild.isExternalLeafNode()) {
                temp = temp.rightChild;
            }
            // Replacing
            node.book = new Book(temp.book);

            // If the node was red, we just convert it to leaf and stop,
            // If the node was black, then we need to rebalance it later.
            if (temp.isRed()) {
                temp = convertToLeafNode(temp);

                return;
            } else {
                temp = convertToLeafNode(temp);

                /**
                 * Now the temp node is the Y node and the parent is the PY node.
                 * We need to balance at PY now.
                 */

                handleRebalanceAtNodeY(temp);
            }
        }

    }

    /**
     * 
     * @param deletionNode
     */
    private void handleDeleteRedNodeDegreeOne(RedBlackTreeNode deletionNode) {

        /**
         * Since the node to be deleted is red, it's parent cannot be red, and the child
         * cannot be red since there are no 2 reds back to back in a redblack tree.
         * Hence we just stitch up the nodeY and nodePY
         */

        RedBlackTreeNode nodeY, nodePY;
        nodePY = deletionNode.parent;
        if (deletionNode.leftChild.isExternalLeafNode()) {
            nodeY = deletionNode.rightChild;
        } else {
            nodeY = deletionNode.leftChild;
        }

        // Linking nodeY to nodePY based on the direction relation of the deletionNode
        // and nodePY
        if (deletionNode == nodePY.leftChild) {
            nodePY.leftChild = nodeY;
            nodeY.parent = nodePY;
        } else {
            nodePY.rightChild = nodeY;
            nodeY.parent = nodeY;
        }

    }

    /**
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * RANGE SEARCH, SEARCH Functionalities
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     * ========================================================================================================================================================================
     */

    private void addToListWhileSearching(int bookID1, int bookID2, RedBlackTreeNode parent) {
        if (parent != null && !parent.isExternalLeafNode()) {
            if (bookID1 <= parent.book.getBookId() && parent.book.getBookId() <= bookID2) {
                rangeSearchResult.add(parent.book);
                addToListWhileSearching(bookID1, bookID2, parent.leftChild);
                addToListWhileSearching(bookID1, bookID2, parent.rightChild);
            }
            if (bookID2 < parent.book.getBookId()) {
                addToListWhileSearching(bookID1, bookID2, parent.leftChild);
            }
            if (bookID1 > parent.book.getBookId()) {
                addToListWhileSearching(bookID1, bookID2, parent.rightChild);
            }
        }
    }

    /**
     * Helper function to return the R.B. Tree node for internal processing.
     * 
     * @param bookID
     * @return
     */
    private RedBlackTreeNode searchNode(int bookID) {

        // implementing a binary search
        RedBlackTreeNode temp = this.getRoot();

        while (!temp.isExternalLeafNode()) {
            if (temp.book.getBookId() == bookID) {
                return temp;
            }
            if (temp.book.getBookId() < bookID) {
                temp = temp.rightChild;
            } else {
                temp = temp.leftChild;
            }
        }

        return temp;
    }

    /**
     * This function is a helper function for traverseForNearestBooks.
     * It empties the array and inserts the book object.
     * 
     * @param books
     * @param book
     */
    private void initializeAndInsertToBooks(List<Book> books, Book book) {

        books = new ArrayList<>();
        books.add(book);

    }

    private int traverseForNearestBooks(RedBlackTreeNode temp, int bookID,
            List<Book> books, int previousDifference) {

        // we do not need to go further down since we found the exact node
        if (previousDifference == 0) {
            traverseForNearestBooks(temp.leftChild, bookID, books, previousDifference);
        }

        while (!temp.isLeafNode()) {

            // Get the difference values
            int leftChildDiff = 0, rightChildDiff = 0;

            if (temp.leftChild.isExternalLeafNode()) {

                rightChildDiff = getDifference(bookID, temp.book);
                if (rightChildDiff < previousDifference) {

                    initializeAndInsertToBooks(books, temp.rightChild.book);
                    previousDifference = rightChildDiff;
                    return previousDifference;
                }

                // Tie Cases
                if (rightChildDiff == previousDifference) {
                    books.add(temp.rightChild.book);
                    return previousDifference;
                }

            }

            if (temp.rightChild.isExternalLeafNode()) {

                leftChildDiff = getDifference(bookID, temp.book);
                if (leftChildDiff < previousDifference) {

                    initializeAndInsertToBooks(books, temp.leftChild.book);
                    previousDifference = leftChildDiff;
                    return previousDifference;
                }

                // Tie Cases
                if (leftChildDiff == previousDifference) {
                    books.add(temp.leftChild.book);
                    return previousDifference;
                }
            }

            // at this stage both nodes are not external leaf node

            leftChildDiff = getDifference(bookID, temp.book);
            rightChildDiff = getDifference(bookID, temp.book);

            // previous Difference is the lowest
            if (previousDifference < leftChildDiff && previousDifference < rightChildDiff) {
                return previousDifference;
            }

            // leftChildDifference is the lowest
            if (leftChildDiff < previousDifference && leftChildDiff < rightChildDiff) {

                previousDifference = leftChildDiff;
                initializeAndInsertToBooks(books, temp.leftChild.book);
                temp = temp.leftChild;
                previousDifference = traverseForNearestBooks(temp, bookID, books,
                        previousDifference);
                return previousDifference;
            }

            // rightChildDifference is the lowest
            if (rightChildDiff < previousDifference && rightChildDiff < leftChildDiff) {

                previousDifference = rightChildDiff;
                initializeAndInsertToBooks(books, temp.rightChild.book);
                temp = temp.rightChild;
                previousDifference = traverseForNearestBooks(temp, bookID, books,
                        previousDifference);
                return previousDifference;
            }

            // Tie Cases
            if (leftChildDiff == rightChildDiff) {

                books.add(temp.leftChild.book);
                return previousDifference;
            }

            // Tie Cases
            if (rightChildDiff == previousDifference) {
                books.add(temp.rightChild.book);
                return previousDifference;
            }

            // if the difference is same as the present difference, add it to the list
            // if the difference is less then create the new list and add it to that list
            // if the difference is more, then check the left and right child,
            // recursively
        }
        return previousDifference;
    }

    private List<Book> findClosestBookIfSearchNotFound(int bookID) {

        List<Book> books = new ArrayList<>();
        // The tree is empty
        if (getRoot().isExternalLeafNode()) {
            return books;
        }

        if (getRoot().leftChild.isExternalLeafNode() &&
                getRoot().rightChild.isExternalLeafNode()) {
            books.add(getRoot().book);
            return books;
        }

        RedBlackTreeNode temp = getRoot();
        int difference = getDifference(bookID, getRoot().book);
        books.add(getRoot().book);
        traverseForNearestBooks(temp, bookID, books, difference);

        return books;
    }

}
