import java.util.concurrent.TimeUnit;

public class ReservationHeapTest {

    /**
     * Focuses if the nodes get heapified when inserted at the end
     */
    public static void test1() {
        try {

            ReservationHeap reservationHeap = new ReservationHeap();
            ReservationHeapNode nodeOne = new ReservationHeapNode(17, 7, System.currentTimeMillis());
            ReservationHeapNode nodeTwo = new ReservationHeapNode(18, 6, System.currentTimeMillis());
            ReservationHeapNode nodeThree = new ReservationHeapNode(19, 5, System.currentTimeMillis());
            ReservationHeapNode nodeFour = new ReservationHeapNode(20, 4, System.currentTimeMillis());
            ReservationHeapNode nodeFive = new ReservationHeapNode(21, 3, System.currentTimeMillis());
            ReservationHeapNode nodeSix = new ReservationHeapNode(22, 2, System.currentTimeMillis());

            reservationHeap.insert(nodeOne);
            reservationHeap.insert(nodeTwo);
            reservationHeap.insert(nodeThree);
            reservationHeap.insert(nodeFour);
            reservationHeap.insert(nodeFive);
            reservationHeap.insert(nodeSix);

            if (reservationHeap.getReservationHeapNodeArray().get(0).getPriorityNumber() == 2
                    && reservationHeap.getReservationHeapNodeArray().get(1).getPriorityNumber() == 4
                    && reservationHeap.getReservationHeapNodeArray().get(2).getPriorityNumber() == 3
                    && reservationHeap.getReservationHeapNodeArray().get(3).getPriorityNumber() == 7
                    && reservationHeap.getReservationHeapNodeArray().get(4).getPriorityNumber() == 5
                    && reservationHeap.getReservationHeapNodeArray().get(5).getPriorityNumber() == 6) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }

        } catch (HeapSizeFullException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Test to see if the priorities are the same, the patron with smaller
     * reservation time gets to the top.
     * 
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        try {

            ReservationHeap reservationHeap = new ReservationHeap();

            long instantBefore = System.currentTimeMillis();
            TimeUnit.MILLISECONDS.sleep(1);
            long instant = System.currentTimeMillis();
            TimeUnit.MILLISECONDS.sleep(1);
            long instantAfter = System.currentTimeMillis();

            ReservationHeapNode nodeOne = new ReservationHeapNode(4, 4, instantAfter);
            ReservationHeapNode nodeTwo = new ReservationHeapNode(3, 4, instant);
            ReservationHeapNode nodeThree = new ReservationHeapNode(2, 4, instantBefore);
            ReservationHeapNode nodeFour = new ReservationHeapNode(1, 2, System.currentTimeMillis());
            TimeUnit.MILLISECONDS.sleep(1);
            ReservationHeapNode nodeFive = new ReservationHeapNode(5, 2, System.currentTimeMillis());

            reservationHeap.insert(nodeOne);
            reservationHeap.insert(nodeTwo);
            reservationHeap.insert(nodeThree);
            reservationHeap.insert(nodeFour);
            reservationHeap.insert(nodeFive);

            if (reservationHeap.getReservationHeapNodeArray().get(0).getPatronID() == 1
                    && reservationHeap.getReservationHeapNodeArray().get(1).getPatronID() == 5
                    && reservationHeap.getReservationHeapNodeArray().get(2).getPatronID() == 3
                    && reservationHeap.getReservationHeapNodeArray().get(3).getPatronID() == 4
                    && reservationHeap.getReservationHeapNodeArray().get(4).getPatronID() == 2) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }

        } catch ( HeapSizeFullException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Test to see if after adding the right element is at the top.
     * 
     * @param args
     * @throws Exception
     */
    public static void test3() throws Exception {

        ReservationHeap reservationHeap = new ReservationHeap();
        ReservationHeapNode nodeOne = new ReservationHeapNode(17, 7, System.currentTimeMillis());
        ReservationHeapNode nodeTwo = new ReservationHeapNode(18, 6, System.currentTimeMillis());
        ReservationHeapNode nodeThree = new ReservationHeapNode(19, 5, System.currentTimeMillis());
        ReservationHeapNode nodeFour = new ReservationHeapNode(20, 4, System.currentTimeMillis());
        ReservationHeapNode nodeFive = new ReservationHeapNode(21, 3, System.currentTimeMillis());
        ReservationHeapNode nodeSix = new ReservationHeapNode(22, 2, System.currentTimeMillis());

        reservationHeap.insert(nodeOne);
        reservationHeap.insert(nodeTwo);
        reservationHeap.insert(nodeThree);
        reservationHeap.insert(nodeFour);
        reservationHeap.insert(nodeFive);
        reservationHeap.insert(nodeSix);

        if (reservationHeap.getTopPriorityPatron().getPriorityNumber() == 2) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    /**
     * Test for getAndDeleteTopPriorityPatron, also checks if insert works after
     * delete.
     * 
     * @param args
     * @throws Exception
     */
    public static void test4() throws Exception {

        ReservationHeap reservationHeap = new ReservationHeap();
        ReservationHeapNode nodeOne = new ReservationHeapNode(17, 7, System.currentTimeMillis());
        ReservationHeapNode nodeTwo = new ReservationHeapNode(18, 6, System.currentTimeMillis());
        ReservationHeapNode nodeThree = new ReservationHeapNode(19, 5, System.currentTimeMillis());
        ReservationHeapNode nodeFour = new ReservationHeapNode(20, 4, System.currentTimeMillis());
        ReservationHeapNode nodeFive = new ReservationHeapNode(21, 3, System.currentTimeMillis());
        ReservationHeapNode nodeSix = new ReservationHeapNode(22, 2, System.currentTimeMillis());
        ReservationHeapNode nodeSeven = new ReservationHeapNode(22, 8, System.currentTimeMillis());

        reservationHeap.insert(nodeOne);
        reservationHeap.insert(nodeTwo);
        reservationHeap.insert(nodeThree);
        reservationHeap.insert(nodeFour);
        reservationHeap.insert(nodeFive);
        reservationHeap.insert(nodeSix);

        ReservationHeapNode node = reservationHeap.getAndDeleteTopPriorityPatron();
        if (node.getPriorityNumber() == 2) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }
        reservationHeap.insert(nodeSeven);
        if (reservationHeap.getReservationHeapNodeArray().get(5).getPriorityNumber() == 8) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    public static void main(String args[]) throws Exception {

        test1();
        test2();
        test3();
        test4();

    }

}
