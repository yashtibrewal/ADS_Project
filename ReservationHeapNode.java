

/**
 * Representation of Node in a Reservation Heap.
 */
public class ReservationHeapNode {
    /**
     * Every node of the Min-heap should contain (patronID,
     * priorityNumber, timeOfReservation)
     */

    private int patronID;
    private int priorityNumber;
    private long timeOfReservation;

    public int getPatronID() {
        return this.patronID;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public int getPriorityNumber() {
        return this.priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public long getTimeOfReservation() {
        return this.timeOfReservation;
    }

    public void setTimeOfReservation(long timeOfReservation) {
        this.timeOfReservation = timeOfReservation;
    }

    public ReservationHeapNode(int patronID, int priorityNumber, long timeOfReservation) {
        this.patronID = patronID;
        this.priorityNumber = priorityNumber;
        this.timeOfReservation = timeOfReservation;
    }

    public ReservationHeapNode(ReservationHeapNode node){
        this.patronID = node.patronID;
        this.priorityNumber = node.priorityNumber;
        this.timeOfReservation = node.timeOfReservation;
    }

    /**
     * @param node
     * @return -1 or +1
     * -1 means the caller node is smaller then the parameter node
     */
    public int compareTo(ReservationHeapNode node){

        if (this.getPriorityNumber() < node.getPriorityNumber()){
            return -1;
        }else if(this.getPriorityNumber() == node.getPriorityNumber()){
            // we break w.r.t to the time
            if(this.getTimeOfReservation() < node.getTimeOfReservation()){
                // if the caller node reserved before the comparing node
                return -1;
            }else {
                return +1;
            }
        }else{
            // if caller node has greater priority, we just send positive
            return +1;
        }

    }

    @Override
    public String toString(){
        return "[PID:"+getPatronID()+",PNo:"+getPriorityNumber()+",Time:"+getTimeOfReservation()+"]";
    }


    // @Override
    // public String toString(){
    //     return getPatronID()+"";
    // }

}
