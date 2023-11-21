import java.util.*;

class Book {

    // There is only one copy of the Book.
    private int bookId;
    private String bookName;
    private String authorName;
    private String abilityStatus; // To indicate whether it is currently borrowed
    private String borrowedBy; // ID of the Patron who borrowed the book
    private ReservationHeap reservationHeap;

    Book(int BookId, String BookName, String AuthorName, String availibilityStatus) {
        this.setBookId(BookId);
        this.setBookName(BookName);
        this.setAuthorName(AuthorName);
        this.setAbilityStatus(availibilityStatus);
        this.reservationHeap = new ReservationHeap();
    }

    Book(Book book) {
        this.bookId = book.bookId;
        this.bookName = book.bookName;
        this.authorName = book.authorName;
        this.abilityStatus = book.abilityStatus;
        this.reservationHeap = book.reservationHeap;
    }

    public int getBookId() {
        return this.bookId;
    }

    private void setBookId(int BookId) {
        this.bookId = BookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    private String getCleanString(String line) {

        /**
         * Trim and remove extra characters
         */
        line = line.trim();
        line = line.replace("\"", "");
        return line;
    }

    private void setBookName(String bookName) {
        this.bookName = getCleanString(bookName);
    }

    public String getAuthorName() {
        return this.authorName;
    }

    private void setAuthorName(String AuthorName) {
        this.authorName = getCleanString(AuthorName);
    }

    public String getBorrowedBy() {
        if (borrowedBy == null || this.borrowedBy.equals("")) {
            return "None";
        }
        return this.borrowedBy;
    }

    public void setBorrowedBy(String BorrowedBy) {
        this.borrowedBy = getCleanString(BorrowedBy);
    }

    public ReservationHeap getReservationHeap() {
        return this.reservationHeap;
    }

    public void setReservationHeap(ReservationHeap ReservationHeap) {
        this.reservationHeap = ReservationHeap;
    }

    public String getAbilityStatus() {
        return this.abilityStatus;
    }

    public void setAbilityStatus(String AbilityStatus) {
        this.abilityStatus = getCleanString(AbilityStatus);
    }

    private boolean assignBook(int patronID, int patronPriority) {

        if (this.isAvailable()) {
            this.setAbilityStatus("NO");
            this.borrowedBy = String.valueOf(patronID);
            return true;
        } else {

            ReservationHeapNode node = new ReservationHeapNode(patronID, patronPriority, System.currentTimeMillis());
            try {
                reservationHeap.insert(node);
            } catch (HeapSizeFullException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;

        }

    }

    private boolean isAvailable() {
        String status = this.getAbilityStatus().toLowerCase();
        String expectedStatus = "yes";
        return status.equals(expectedStatus);
    }

    public boolean borrowBook(int patronID, int patronPriority) {

        return assignBook(patronID, patronPriority);

    }

    public String returnBook(int patronID) {

        // if (!this.isAvailable()) {
            this.borrowedBy = null;
            if (reservationHeap.getSize() > 0) { // We have atleast 1 reservation
                try {
                    int patronId = reservationHeap.getAndDeleteTopPriorityPatron().getPatronID();
                    setBorrowedBy(patronID + "");
                    return patronId + "";
                } catch (NoElementInHeapException e) {
                    setAbilityStatus("YES");
                    return "";
                }
            }else{
                return "";
            }
        // } else {
        //     // TODO: handle as to what to do if the status is YES already
        // }
        // return "";

    }

    public List<Integer> getReservationPatronIDs() {
        List<Integer> patronIds = this.reservationHeap.getPatronIds();
        return patronIds;
    }

    /**
     * Generates the array for patron ids in the reservation
     * 
     * @return
     */
    public String getReservationPatronReservations() {

        List<Integer> ids = new ArrayList<>();
        for (ReservationHeapNode node : reservationHeap.getReservationHeapNodeArray()) {
            ids.add(node.getPatronID());
        }
        return ids.toString();
    }


    public String toString(){
        return ""+this.getBookId();
    }

}