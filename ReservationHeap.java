import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Min Heap for storing the patrons reservations for the book.
 */
public class ReservationHeap {

    private List<ReservationHeapNode> reservationHeapNodes;
    private final int maxHeapSize;
    private int heapSize;

    ReservationHeap(){
        this.reservationHeapNodes = new ArrayList<>(20);
        this.heapSize = 0;
        this.maxHeapSize = 20;
    }

    public int getSize(){
        return this.heapSize;
    }

    public List<ReservationHeapNode> getReservationHeapNodeArray() {
        return reservationHeapNodes;
    }

    private void swapNodes(int indexOne, int indexTwo) {

        ReservationHeapNode nodeIndexOne = this.reservationHeapNodes.get(indexOne);
        ReservationHeapNode nodeIndexTwo = this.reservationHeapNodes.get(indexTwo);
        ReservationHeapNode temp = new ReservationHeapNode(nodeIndexOne.getPatronID(), nodeIndexOne.getPriorityNumber(),
                nodeIndexOne.getTimeOfReservation());

        nodeIndexOne.setPatronID(nodeIndexTwo.getPatronID());
        nodeIndexOne.setPriorityNumber(nodeIndexTwo.getPriorityNumber());
        nodeIndexOne.setTimeOfReservation(nodeIndexTwo.getTimeOfReservation());

        nodeIndexTwo.setPatronID(temp.getPatronID());
        nodeIndexTwo.setPriorityNumber(temp.getPriorityNumber());
        nodeIndexTwo.setTimeOfReservation(temp.getTimeOfReservation());

    }

    /**
     * 
     * @param nodeOne
     * @param nodeTwo
     * @return
     *         If the properties of nodeOne are smaller then nodeTwo, we return
     *         true, else false.
     */
    private boolean isNodeOneSmallerThenNodeTwo(ReservationHeapNode nodeOne, ReservationHeapNode nodeTwo) {
        if (nodeOne.compareTo(nodeTwo) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(ReservationHeapNode node) throws HeapSizeFullException, InterruptedException {

        /**
         * Algorithm:
         * Insert the node at the end of the list, if the value is smaller
         * then it's parent node, we swap the nodes. We recursively check the same thing
         * until we reach the root node, OR if the parent node is smaller then the root
         * node.
         */
        TimeUnit.MILLISECONDS.sleep(1);

        if (this.heapSize == this.maxHeapSize) {
            throw new HeapSizeFullException();
        }

        this.reservationHeapNodes.add(node);
        this.heapSize++;
        int index = this.heapSize - 1;
        int parentIndex = this.getParentIndex(index);

        while (parentIndex != 0
                && this.isNodeOneSmallerThenNodeTwo(this.reservationHeapNodes.get(index),
                        this.reservationHeapNodes.get(parentIndex))
                || index == 1 && this.isNodeOneSmallerThenNodeTwo(this.reservationHeapNodes.get(index),
                        this.reservationHeapNodes.get(parentIndex))
                || index == 2 && this.isNodeOneSmallerThenNodeTwo(this.reservationHeapNodes.get(index),
                        this.reservationHeapNodes.get(parentIndex))) {
            swapNodes(index, parentIndex);
            index = parentIndex;
            parentIndex = this.getParentIndex(index);
        }

    }

    /**
     * Gets the highest priority Patron (Minimum Magnitude of Priority from the
     * heap). Does not delete the Patron from the Prioirty Heap.
     * 
     * @return ReservationHeapNode
     */
    public ReservationHeapNode getTopPriorityPatron() throws Exception {
        return reservationHeapNodes.get(0);
    }

    /**
     * Gets and delets the highest priority Patron from the list.
     * 
     * @return ReservationHeapNode
     * @throws NoElementInHeapException
     */
    public ReservationHeapNode getAndDeleteTopPriorityPatron() throws NoElementInHeapException {

        if (this.heapSize == 0) {
            throw new NoElementInHeapException();
        }
        ReservationHeapNode reservationHeapNode = new ReservationHeapNode(reservationHeapNodes.get(0));
        this.heapSize--;
        // Delete the 0th index node, and call heapify after replacing the last node.

        if (this.heapSize == 0) { // if the heap is empty, just return the element.
            return reservationHeapNode;
        }
        heapify(0);
        return reservationHeapNode;
    }

    /**
     * Perform operations after the Heap has lost root..
     */
    public void heapify(int index) {
        reservationHeapNodes.set(0, reservationHeapNodes.get(heapSize));
        reservationHeapNodes.remove(reservationHeapNodes.size() - 1);

        if (this.heapSize == 1) { // do nothing if the heap size is 1
            return;
        }
        // check the parent element with its left child and right child

        // the minimum of all 3 nodes sits on the top and is replaced by the parent node
        // the node which is replaced is again checked for its children.

        // we stop when we reach a leaf node.
        while (!isLeafNode(index)) {
            if (hasLeftChild(index) && !hasRightChild(index)) {
                int leftChildIndex = getLeftChildIndex(index);
                if (isNodeOneSmallerThenNodeTwo(reservationHeapNodes.get(leftChildIndex),
                        reservationHeapNodes.get(index)))
                    swapNodes(index, leftChildIndex);
                return; // We end the function here because if there was no right child, there are no
                        // elements remaining in the heap.
            } else if (hasLeftChild(index) && hasRightChild(index)) {

                int leftChildIndex = getLeftChildIndex(index);
                int rightChildIndex = getRightChildIndex(index);
                ReservationHeapNode leftChild = reservationHeapNodes.get(leftChildIndex);
                ReservationHeapNode rightChild = reservationHeapNodes.get(rightChildIndex);
                ReservationHeapNode parent = reservationHeapNodes.get(index);
                if (isNodeOneSmallerThenNodeTwo(leftChild, rightChild)
                        && isNodeOneSmallerThenNodeTwo(leftChild, parent)) { // if leftChild is the smallest.
                    swapNodes(leftChildIndex, index);
                    index = leftChildIndex;
                } else if (isNodeOneSmallerThenNodeTwo(rightChild, leftChild)
                        && isNodeOneSmallerThenNodeTwo(rightChild, parent)) { // if right child is the smallest
                    swapNodes(rightChildIndex, index);
                    index = rightChildIndex;
                } else {
                    // since leftchild is not smaller then parent and right child is not smaller
                    // then parent, hence parent should be the smallest.
                    return;
                }
            } // There is no case where we would have a right child but not the left child.
        }
    }

    public int getParentIndex(int i) {

        int parentIndex = i - 1;

        /*
         * Going 1 level up, since its integer division,
         * Since the left children are odd index,
         * it will give floor division and parent's index
         */
        parentIndex = parentIndex / 2;

        return parentIndex;
    }

    public int getLeftChildIndex(int i) {

        /*
         * Going 1 level down
         */
        int leftChildIndex = i * 2;

        leftChildIndex = leftChildIndex + 1;

        return leftChildIndex;
    }

    public int getRightChildIndex(int i) {

        /*
         * Going 1 level down
         */
        int leftChildIndex = i * 2;

        leftChildIndex = leftChildIndex + 2;

        return leftChildIndex;
    }

    /**
     * 
     * @param index
     * @return true if the node is a leaf node in the heap
     */
    public boolean isLeafNode(int index) {

        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getLeftChildIndex(index);

        if (leftChildIndex >= this.heapSize && rightChildIndex >= this.heapSize) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param index
     * @return returns false if the node has a left child.
     */
    public boolean hasLeftChild(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        if (leftChildIndex < this.heapSize)
            return true;
        return false;
    }

    /**
     * 
     * @param index
     * @return returns true if the node has a right child.
     */
    public boolean hasRightChild(int index) {
        int rightChildIndex = getRightChildIndex(index);
        if (rightChildIndex < this.heapSize)
            return true;
        return false;
    }

    @Override
    public String toString() {

        return this.getReservationHeapNodeArray().toString();

    }

    
    public List<Integer> getPatronIds() {
        List<Integer> ids = new ArrayList<>();
        for(ReservationHeapNode node:reservationHeapNodes){
            ids.add(node.getPatronID());
        }
        return ids;
    }

}
