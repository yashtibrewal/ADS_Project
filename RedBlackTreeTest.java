import java.util.List;

public class RedBlackTreeTest {

    /**
     * ================================================================================================
     * Insertion Tests Start Here
     * ================================================================================================
     */
    /**
     * To Check if the redblack tree is initiatized with an external node.
     */
    public static void testRBInit() {

        RedBlackTree redBlackTree = new RedBlackTree();

        if (redBlackTree.getRoot().isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * To test if the tree holds the element and 2 external nodes when inserted once
     * 
     * @throws FileProcessorException
     */
    public static void testInsertingAtRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(1, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 1
                && redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * To test insertion at level 2.
     * 
     * @throws FileProcessorException
     */
    public static void testInsertingAtLevel2() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(2, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(3, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(1, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 2
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 1
                && redBlackTree.getRoot().rightChild.book.getBookId() == 3
                && redBlackTree.getRoot().leftChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LLb at root.
     * 
     * @throws FileProcessorException
     */
    public static void testLLbRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 12
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().rightChild.book.getBookId() == 14
                && redBlackTree.getRoot().leftChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test RRb at root.
     * 
     * @throws FileProcessorException
     */
    public static void testRRbRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 12
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().rightChild.book.getBookId() == 14
                && redBlackTree.getRoot().leftChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LRb at root.
     * 
     * @throws FileProcessorException
     */
    public static void testLRbRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 13
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 12
                && redBlackTree.getRoot().rightChild.book.getBookId() == 14
                && redBlackTree.getRoot().leftChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test RLb at root.
     * 
     * @throws FileProcessorException
     */
    public static void testRLbRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 15
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 14
                && redBlackTree.getRoot().rightChild.book.getBookId() == 16
                && redBlackTree.getRoot().leftChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LRb not at root. Meaning at deeper levels
     * 
     * @throws FileProcessorException
     */
    public static void testLRb() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.getRoot().rightChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.getRoot().leftChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.insert(new Book(10, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 14
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().rightChild.book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 10
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 12) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LRb not at root.
     * 
     * @throws FileProcessorException
     */
    public static void testRLb() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.getRoot().rightChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.getRoot().leftChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.insert(new Book(17, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(19, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 14
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 12
                && redBlackTree.getRoot().rightChild.book.getBookId() == 17
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 15
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 19) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * Testing a LLb problem at non root.
     * 
     * @throws FileProcessorException
     */
    public static void testLLb() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.getRoot().rightChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.getRoot().leftChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.insert(new Book(10, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(9, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 12
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 10
                && redBlackTree.getRoot().rightChild.book.getBookId() == 14
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 9
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 11) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test RRb problem at deeper levels
     */
    public static void testRRb() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.getRoot().rightChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.getRoot().leftChild.color = RedBlackTreeNode.NodeColor.BLACK;
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(17, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 12
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().rightChild.book.getBookId() == 15
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 14
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 17) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LLr problem at root
     */
    public static void testLLrRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 14
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 12
                && redBlackTree.getRoot().rightChild.book.getBookId() == 15
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LLr at deeper levels of tree.
     */
    public static void testLLr() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(10, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 14
                && !redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && !redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 12
                && redBlackTree.getRoot().rightChild.book.getBookId() == 15
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 13
                && redBlackTree.getRoot().leftChild.leftChild.leftChild.book.getBookId() == 10) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test a LLr problem followed by a LLb problem
     */
    public static void testLLrFollowedByLLb() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(10, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(9, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 13
                && redBlackTree.getRoot().leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().rightChild.book.getBookId() == 15
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.rightChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 10
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 12
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 14
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.leftChild.leftChild.book.getBookId() == 9
                && redBlackTree.getRoot().leftChild.leftChild.leftChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * to Test a RRr insert at Root
     */
    public static void testRRrRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(100, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(25, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(125, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(115, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(180, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(190, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 100
                && redBlackTree.getRoot().leftChild.book.getBookId() == 25
                && redBlackTree.getRoot().rightChild.book.getBookId() == 125
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().rightChild.leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 115
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 180
                && redBlackTree.getRoot().rightChild.rightChild.rightChild.book.getBookId() == 190) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test RLr porblem at root
     */
    public static void testRLrRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.book.getBookId() == 13
                && redBlackTree.getRoot().rightChild.book.getBookId() == 18
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.leftChild.isRed()
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 16) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test LRr at root.
     */
    public static void testLRrRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.book.getBookId() == 13
                && redBlackTree.getRoot().rightChild.book.getBookId() == 18
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().leftChild.rightChild.isRed()
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 14
                && redBlackTree.getRoot().leftChild.rightChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * ================================================================================================================================================================================================
     * ================================================================================================================================================================================================
     * ================================================================================================================================================================================================
     * ================================================================================================================================================================================================
     * ================================================================================================================================================================================================
     * Deletion Tests Start Here
     * ================================================================================================================================================================================================
     */

    /**
     * Deleting a root black node with 0 child nodes #root.
     */
    public static void testHandleDeleteBlackNodeDegreeZeroRoot() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(16);
        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * To test deleting a red node in the left subtree
     */
    public static void testDeleteRedNodeDegreeZeroL() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.delete(13);

        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().book.getBookId() == 15
                && redBlackTree.getRoot().rightChild.book.getBookId() == 18
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * To test delete a Red Node in the right subtree.
     */
    public static void testDeleteRedNodeDegreeZeroR() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.delete(18);

        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.book.getBookId() == 13
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.isExternalLeafNode()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * Deleting a red node with 2 black children with red acting someone's left
     * subtree.
     * The Left black node has a leftchild and no rightchild.
     */
    public static void testHandleDeleteRedNodeDegreeTwoL() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(11, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        redBlackTree.delete(13);

        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.book.getBookId() == 12
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 11
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 14
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Deleting a red node with 2 black children with red acting someone's left
     * subtree.
     * The Left black node has a rightchild and no leftchild.
     */
    public static void testHandleDeleteRedNodeDegreeTwoR() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(12, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(13, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());

        redBlackTree.delete(14);

        // System.out.println(redBlackTree.toString());

        if (redBlackTree.getRoot().book.getBookId() == 16
                && redBlackTree.getRoot().leftChild.book.getBookId() == 13
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 12
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Deleting a black node with 0 child nodes where the deleted node is a
     * left subtree. Same as Lb0 at root.
     */
    public static void testHandleDeleteBlackNodeDegreeZeroL() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(15); // Inserted 15, convert the 18 and 14 to black
        redBlackTree.delete(14);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 16
                && redBlackTree.getRoot().leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().rightChild.book.getBookId() == 18) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Deleting a black node with 0 child nodes where the deleted node is a
     * left subtree. Same as Rb0 at root.
     */
    public static void testHandleDeleteBlackNodeDegreeZeroR() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(14, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(17, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(17);
        redBlackTree.delete(18);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 16
                && redBlackTree.getRoot().rightChild.isExternalLeafNode()
                && redBlackTree.getRoot().isBlack()
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().leftChild.book.getBookId() == 14) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * tests for Deletion in the case Lb0 Case Two
     */
    public static void testHandleDeleteBlackNodeDeeperLevelLb0CaseTwo() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(18);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 34
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.isRed()
                && redBlackTree.getRoot().leftChild.rightChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Lb1 Case One
     * Where Lb1 happens on a left subtree
     */
    public static void testHandleDeleteBlackNodeDeeperLevelLb1CaseOneL() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(36, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(34);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 36
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.isRed()
                && redBlackTree.getRoot().leftChild.rightChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Lb1 Case One
     * Where Lb1 Case One happens on a right subtree
     */
    public static void testHandleDeleteBlackNodeDeeperLevelLb1CaseOneR() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(110, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(67);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().rightChild.book.getBookId() == 106
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 98
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 110
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().rightChild.leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Lb1 Case Two
     */
    public static void testHandleDeleteBlackNodeDeeperLevelLb1CaseTwo() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(32, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(34);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 32
                && redBlackTree.getRoot().leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.leftChild.isRed()
                && redBlackTree.getRoot().leftChild.rightChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Lb2
     */
    public static void testHandleDeleteBlackNodeDeeperLevelLb2() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(28, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(35, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(18);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().leftChild.book.getBookId() == 28
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 34
                && redBlackTree.getRoot().leftChild.rightChild.rightChild.book.getBookId() == 35
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Rb0 Case Two
     */
    public static void testHandleDeleteBlackNodeDeeperLevelRb0CaseTwo() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(110, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(110); // TODO: remove 110 and debug
        redBlackTree.delete(67);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().rightChild.leftChild.isExternalLeafNode()
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 106
                && redBlackTree.getRoot().rightChild.isBlack()
                && redBlackTree.getRoot().rightChild.leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.rightChild.isRed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Rb1 Case One
     * Where Rb1 happens on a left subtree
     */
    public static void testHandleDeleteBlackNodeDeeperLevelRb1CaseOneL() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(10, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(34);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().leftChild.book.getBookId() == 18
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 10
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * Deleting a root black node with 0 child nodes where the deleted node is a
     * left subtree at deeper level to trigger recursive up level rebalancing
     * Also handles the case Rb1 Case One on the left subtree.
     */
    public static void testHandleDeleteBlackNodeRb1CaseOneL() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(15, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(34);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 15
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * tests for Deletion in the case Rb1 Case One
     * Where Rb1 Case One happens on a right subtree
     */
    public static void testHandleDeleteBlackNodeDeeperLevelRb1CaseOneR() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(65, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(106);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().rightChild.book.getBookId() == 67
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 65
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().rightChild.leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Rb1 Case Two in a right subtree
     */
    public static void testHandleDeleteBlackNodeDeeperLevelRb1CaseTwoR() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(80, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(106);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().rightChild.book.getBookId() == 80
                && redBlackTree.getRoot().leftChild.book.getBookId() == 27
                && redBlackTree.getRoot().rightChild.leftChild.book.getBookId() == 67
                && redBlackTree.getRoot().rightChild.rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().rightChild.isRed()
                && redBlackTree.getRoot().rightChild.leftChild.isBlack()
                && redBlackTree.getRoot().rightChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * tests for Deletion in the case Rb2
     */
    public static void testHandleDeleteBlackNodeDeeperLevelRb2() {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(19, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        // System.out.println(redBlackTree.toString());
        redBlackTree.delete(34);
        // System.out.println(redBlackTree.toString());

        if (!redBlackTree.getRoot().isExternalLeafNode()
                && redBlackTree.getRoot().book.getBookId() == 45
                && redBlackTree.getRoot().leftChild.book.getBookId() == 19
                && redBlackTree.getRoot().rightChild.book.getBookId() == 98
                && redBlackTree.getRoot().leftChild.leftChild.book.getBookId() == 18
                && redBlackTree.getRoot().leftChild.rightChild.book.getBookId() == 27
                && redBlackTree.getRoot().leftChild.leftChild.leftChild.book.getBookId() == 16
                && redBlackTree.getRoot().leftChild.isRed()
                && redBlackTree.getRoot().leftChild.leftChild.isBlack()
                && redBlackTree.getRoot().leftChild.rightChild.isBlack()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    /**
     * This is to check if the tree dissolves correctly to an empty try
     */
    public static void deleteRootConcequently() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        System.out.println(redBlackTree);

        redBlackTree.delete(45);
        redBlackTree.delete(34);
        redBlackTree.delete(27);
        // System.out.println(redBlackTree);
        redBlackTree.delete(18); // Reaches a stage not mentioned in the slides.
        // System.out.println(redBlackTree);
    }

    /**
     * ================================================================================================================================================================================================
     * ================================================================================================================================================================================================
     * Color Flip Tests Start Here
     * ================================================================================================================================================================================================
     */

    /**
     * To test if color flip count increases after a color Flip.
     */
    public static void testOneColorFlip() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        if (redBlackTree.getColorFlipCount() == 1) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * To test if color flip count increases after two color flips.
     */
    public static void testTwoColorFlips() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        if (redBlackTree.getColorFlipCount() == 2) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * To test if color flip count increases after multiple color Flips.
     */
    public static void testMultipleColorFlips() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        if (redBlackTree.getColorFlipCount() == 3) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * To test if color flip count increases after multiple color Flips.
     * And it does not increase if there are color changes due to rotation and
     * deletion
     */
    public static void testMultipleColorFlipsAndDelete() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.delete(18);
        redBlackTree.delete(45);
        redBlackTree.delete(106);
        redBlackTree.delete(67);

        if (redBlackTree.getColorFlipCount() == 3) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * ================================================================================================================================================================================================
     * ================================================================================================================================================================================================
     * Range Search Tests Start Here
     * ================================================================================================================================================================================================
     */

    /**
     * Testing to get a middle group of elements
     */
    public static void testRangeSearchMiddleGroup() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        List<Book> books = redBlackTree.rangeSearch(30, 70);
        // System.out.println(books);
        if (books.size() == 3
                && books.get(0).getBookId() == 34
                && books.get(1).getBookId() == 45
                && books.get(2).getBookId() == 67) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Empty Result test
     */
    public static void testRangeSearchForEmptyResult() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        List<Book> books = redBlackTree.rangeSearch(35, 40);
        // System.out.println(books);
        if (books.size() == 0) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Left most node
     */
    public static void testRangeSearchForLeftExtreme() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        List<Book> books = redBlackTree.rangeSearch(15, 17);
        // System.out.println(books);
        if (books.size() == 1
                && books.get(0).getBookId() == 16) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Full Result test
     */
    public static void testRangeSearchForAllResult() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        List<Book> books = redBlackTree.rangeSearch(0, 200);
        // System.out.println(books);
        if (books.size() == 9) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Fine Nearest Test
     */
    public static void testFindNearest() {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(new Book(45, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(27, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(98, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(18, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(34, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(67, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(106, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(16, "Not a penny more not a penny less", "Jeffery Archer", "YES"));
        redBlackTree.insert(new Book(107, "Not a penny more not a penny less", "Jeffery Archer", "YES"));

        List<Book> books = redBlackTree.findClosestBook(200);
        System.out.println(books);
        if (books.size() == 1
                && books.get(0).getBookId() == 107) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    public static void main(String args[]) {

        // testRBInit();

        /**
         * NODE INSERT TESTS
         */
        testInsertingAtRoot();
        testInsertingAtLevel2();
        testLLbRoot();
        testLLb();
        testLRbRoot();
        testLRb();
        testRRbRoot();
        testRRb();
        testRLbRoot();
        testRLb();
        testLLrRoot();
        testLLr();
        testLLrFollowedByLLb();
        testRRrRoot();
        testRLrRoot();
        testLRrRoot();

        /**
         * NODE DELETE Tests
         */
        testDeleteRedNodeDegreeZeroL();
        testDeleteRedNodeDegreeZeroR();
        testHandleDeleteRedNodeDegreeTwoL();
        testHandleDeleteRedNodeDegreeTwoR();
        testHandleDeleteBlackNodeDegreeZeroRoot();
        testHandleDeleteBlackNodeDegreeZeroL();
        testHandleDeleteBlackNodeDegreeZeroR();
        testHandleDeleteBlackNodeRb1CaseOneL();
        testHandleDeleteBlackNodeDeeperLevelLb0CaseTwo();
        testHandleDeleteBlackNodeDeeperLevelLb1CaseOneL();
        testHandleDeleteBlackNodeDeeperLevelLb1CaseOneR();
        testHandleDeleteBlackNodeDeeperLevelLb1CaseTwo();
        testHandleDeleteBlackNodeDeeperLevelLb2();
        testHandleDeleteBlackNodeDeeperLevelRb0CaseTwo();
        testHandleDeleteBlackNodeDeeperLevelRb1CaseOneL();
        testHandleDeleteBlackNodeDeeperLevelRb1CaseOneR();
        testHandleDeleteBlackNodeDeeperLevelRb1CaseTwoR();
        testHandleDeleteBlackNodeDeeperLevelRb2();

        /**
         * COLOR FLIP TESTS
         */
        testOneColorFlip();
        testTwoColorFlips();
        testMultipleColorFlips();
        testMultipleColorFlipsAndDelete();

        /**
         * RANGE SEARCH TESTS
         */
        testRangeSearchMiddleGroup();
        testRangeSearchForEmptyResult();
        testRangeSearchForLeftExtreme();
        testRangeSearchForAllResult();

        /**
         * FIND NEAREST TESTS
         */

        // testFindNearest();

    }

    // Unhandled cases
    // deleteRootConcequently();

}
