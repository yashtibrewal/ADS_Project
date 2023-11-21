
public class RedBlackTreeNode {

    enum NodeColor {
        RED,
        BLACK;
    }

    // Data
    Book book;

    NodeColor color;

    RedBlackTreeNode parent;
    RedBlackTreeNode leftChild;
    RedBlackTreeNode rightChild;

    /**
     * Used for a creation of an external node
     */
    RedBlackTreeNode() {
        this.color = NodeColor.BLACK;
        this.book = null;
        this.leftChild = this.rightChild = this.parent = null;
    }

    RedBlackTreeNode(RedBlackTreeNode node) {
        this.book = new Book(node.book);
        this.leftChild = node.leftChild;
        this.rightChild = node.rightChild;
        this.parent = node.parent;
    }

    /**
     * A node with null pointer to book is considered a leaf node.
     * 
     * @return
     */
    public boolean isExternalLeafNode() {
        if (this.book == null) {
            return true;
        } else {
            return false;
        }
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public boolean isBlack() {
        return this.color == NodeColor.BLACK;
    }

    public boolean isRed() {
        return this.color == NodeColor.RED;
    }

    @Override
    public String toString() {

        if (book == null) {
            return "[EX-LEAF]";
        }
        // String parent = "NULL";
        // if(this.parent!=null){
        //     parent = this.parent.book.getBookId() + "";
        // }

        return "[B: " + book.getBookId() + ", C: " + color +"]";

    }

    /**
     * If it has 2 external leaf nodes as children then it is a leaf node
     * @return
     */
    public boolean isLeafNode() {
        return this.leftChild!=null && this.rightChild!= null 
            && this.leftChild.isExternalLeafNode() && this.rightChild.isExternalLeafNode();
    }

}
