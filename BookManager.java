import java.util.*;

/**
 * This class is reponsible to generate the output in String formates and pass it back to the the caller.
 * It is also responsible to use the Red Black Tree Data Structure inside it and manage the books as per the commands
 */
public class BookManager {

    RedBlackTree redBlackTree;

    BookManager() {
        redBlackTree = new RedBlackTree();
    }

    private String generatePrintBookResult(Book book) {

        return "BookID = " + book.getBookId() + "\n"
                + "Title = " + book.getBookName().trim() + "\n"
                + "Author = " + book.getAuthorName().trim() + "\n"
                + "Availibility = " + book.getAbilityStatus().trim() + "\n"
                + "BorrowedBy = " + book.getBorrowedBy() + "\n"
                + "Reservations = " + book.getReservationPatronReservations() + "\n";

    }

    /**
     * 
     * @param bookID
     * @return If the book exists,
     *         BookID = <bookID>
     *         Title = "<bookName>"
     *         Author = "<Author Name"
     *         Availability = "<Yes | No>"
     *         BorrowedBy = <Patron Id | None>
     *         Reservations = [patron1_id,patron2_id,....]
     *         If the book does not exists, then return
     *         BookID not found in the Library
     */
    public String printBook(int bookID) {
        Book book = redBlackTree.search(bookID);
        if (book == null) {
            // Handle book not Found
            return "Book " + bookID + " does not exist\n\n";
        }
        String result = generatePrintBookResult(book);

        return result;
    }

    /**
     * This function is a helper function which helps to create the output format
     * to print multiple books
     * @param books
     * @return
     */
    public List<String> generatePrintBooksResult(List<Book> books) {

        Collections.sort(books, new BookComparator());

        List<String> results = new ArrayList<>();

        for (Book book : books) {
            results.add(generatePrintBookResult(book));
        }

        return results;
    }

    /**
     * 
     * @param bookID
     * @param bookName
     * @param authorName
     * @param avialabilityStatus
     * 
     *                           Add a new book to the library. BookID should be
     *                           unique, and availability indicates whether the book
     *                           is available for borrowing.
     *                           Note*: There is only one copy of a book i.e. all
     *                           books are unique.
     */
    public void insertBook(int bookID,
            String bookName,
            String authorName,
            String avialabilityStatus) {

        Book newBook = null;
        newBook = new Book(bookID, bookName, authorName, avialabilityStatus);
        redBlackTree.insert(newBook);

    }

    /**
     * 
     * @param patronID
     * @param bookID
     * @param patronPriority
     * 
     *                       Allow a patron to borrow a book that is available
     *                       and update the status of the book. If a book is
     *                       currently unavailable, create a reservation node in the
     *                       heap
     *                       as per the patron’s priority (patronPriority).
     */
    public String borrowBook(int patronID, int bookID, int patronPriority) {

        Book book = redBlackTree.search(bookID);
        if (book == null) {
            // Handle book not Found
            return "Book " + bookID + " does not exist\n\n";
        }
        boolean wasBorrowed = book.borrowBook(patronID, patronPriority);
        if (wasBorrowed) {
            return "Book " + bookID + " Borrowed by Patron " + patronID + "\n\n";
        } else {
            return "Book " + bookID + " Reserved by Patron " + patronID + "\n\n";
        }
    }

    /**
     * Allow a patron to return a borrowed book. Update the book's status
     * and assign the book to the patron with highest priority in the Reservation
     * Heap. (if there’s a reservation).
     * 
     * @return
     */
    public String returnBook(int patronID, int bookID) {

        Book book = redBlackTree.search(bookID);
        if (book == null) {
            // Handle book not Found
            return "Book " + bookID + " does not exist\n\n";
        }
        String assignedTo = book.returnBook(patronID);

        String result = "Book " + bookID + " Returned by Patron " + patronID + "\n\n";
        if (!assignedTo.isEmpty()) {
            result += "Book " + bookID + " Alloted to Patron " + assignedTo + "\n\n";
        }

        return result;

    }

    /**
     * @param bookID
     *               Delete the book from the library and notify the patrons in the
     *               reservation list
     *               that the book is no longer available to borrow.
     * @return
     */
    public String deleteBook(int bookID) {

        String result = "Book 2 is no longer available.";
        List<Integer> patronIds = redBlackTree.delete(bookID);
        if (patronIds.size() != 0) {
            result += getPatronMessage(patronIds);
        }
        return result;
    }

    /**
     * This function is a helper function used to create the message based on patron ids
     * for the output file.
     * @param patronIds
     * @return
     */
    private String getPatronMessage(List<Integer> patronIds) {

        String message = " Reservations made by Patrons ";
        for (int id : patronIds) {
            message += id + ",";
        }
        message = message.substring(0, message.length() - 1);
        message += " have been cancelled!";
        return message;

    }

    /**
     * @param targetID
     *                 Find the book with an ID closest to the given ID (checking on
     *                 both sides
     *                 of the ID). Print all the details about the book. In case of
     *                 ties, print both
     *                 the books ordered by bookIDs.
     * @return 
     */
    public List<Book> findClosestBook(int targetID) {
        return redBlackTree.findClosestBook(targetID);
    }

    /**
     * GatorLibrary's Red-Black tree structure requires an analytics tool to monitor
     * and
     * analyze the frequency of color flips in the Red-Black tree. Track the
     * occurrence of color changes in the
     * Red-Black tree nodes during tree operations, such as insertion, deletion, and
     * rotations.
     * Note*: Only color flips should be counted i.e. when black changes to red and
     * vice versa.
     */
    public int colorFlipCount() {
        return redBlackTree.getColorFlipCount();
    }

    public List<Book> rangeSearch(int bookID1, int bookID2) {

        List<Book> books = redBlackTree.rangeSearch(bookID1, bookID2);

        return books;
    }

}
