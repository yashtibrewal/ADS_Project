import java.util.*;
import java.util.concurrent.*;;

/**
 * Place where we would be calling all the functions.
 */

public class Controller {

    private FileProcessor fileProcessor;
    private BookManager bookManager;

    Controller(String fileName) throws FileProcessorException {
        FileProcessor.initializeFileProcessor(fileName);
        this.fileProcessor = FileProcessor.getFileProcessor();
        this.bookManager = new BookManager();
    }

    /**
     * 
     * @param command
     * @return
     *         Returns 13,14 from function(13,14)
     * 
     */
    private String getParameters(String command) {

        return command.substring(
                command.indexOf('(') + 1,
                command.indexOf(')'));

    }

    /**
     * 
     * @param command
     * @return
     *         Returns function from function(13,14)
     * 
     */
    private String getCommand(String command) {

        return command.substring(0,
                command.indexOf('('));

    }

    /**
     * Since the lowest unit of time recorded for adding a patron is millisecond,
     * this will help to keep the the inserted patron's insertion time different.
     * 
     * @throws InterruptedException
     */
    public void waitOneMilliSecond() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * Helper function
     * 
     * @param num
     * @return
     */
    private int getIntegerFromString(String num) {
        num = num.trim();
        return Integer.parseInt(num);
    }

    private void parseCommand(String line) {

        /**
         * PrintBook(bookID)
         * PrintBooks(bookID1, bookID2)
         * InsertBook(bookID, bookName, authorName, availabilityStatus, borrowedBy,
         * reservationHeap)
         * BorrowBook(patronID, bookID, patronPriority)
         * ReturnBook(patronID, bookID)
         * DeleteBook(bookID)
         * FindClosestBook(targetID)
         * ColorFlipCount()
         */

        String command = this.getCommand(line);

        switch (command) {
            case "PrintBook": {
                int bookID = getIntegerFromString(getParameters(line));
                String result = this.bookManager.printBook(bookID);
                this.fileProcessor.writeResultToFile(result);
                this.fileProcessor.writeResultToFile("\n");
                break;
            }
            case "PrintBooks": {

                String params = this.getParameters(line);
                String paramsArray[] = params.split(",");
                int bookID1 = getIntegerFromString(paramsArray[0]);
                int bookID2 = getIntegerFromString(paramsArray[1]);

                List<Book> books = bookManager.rangeSearch(bookID1, bookID2);
                List<String> results = bookManager.generatePrintBooksResult(books);

                printBooks(results);

                break;
            }
            case "InsertBook": {

                String params = this.getParameters(line);
                String paramsArray[] = params.split(",");
                int bookID = getIntegerFromString(paramsArray[0]);
                String title = paramsArray[1];
                String author = paramsArray[2];
                String availibility = paramsArray[3];
                this.bookManager.insertBook(bookID, title, author, availibility);
                break;
            }

            /**
             * BorrowBook(patronID, bookID, patronPriority):
             */
            case "BorrowBook": {
                // If the book is already borrowed, insert a new reservationnode

                // Get the book from the RedBlackTree

                // Check the availibility of that book

                // If it is avaialble assign the book

                // If not create a new reservation

                // Wait one millisecond before creating a new reservation. Reason: To not have
                // the same timestamp.
                try {

                    String params = this.getParameters(line);
                    String paramsArray[] = params.split(",");

                    int patronID = getIntegerFromString(paramsArray[0]);
                    int bookID = getIntegerFromString(paramsArray[1]);
                    int patronPriority = getIntegerFromString(paramsArray[2]);
                    String result = bookManager.borrowBook(patronID, bookID, patronPriority);
                    this.fileProcessor.writeResultToFile(result);

                    waitOneMilliSecond();

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
            case "ReturnBook": {

                String params = this.getParameters(line);
                String paramsArray[] = params.split(",");

                int patronID = getIntegerFromString(paramsArray[0]);
                int bookID = getIntegerFromString(paramsArray[1]);
                String result = this.bookManager.returnBook(patronID, bookID);
                this.fileProcessor.writeResultToFile(result);
                break;
            }

            case "DeleteBook": {

                int bookID = getIntegerFromString(this.getParameters(line));
                String result = this.bookManager.deleteBook(bookID);
                this.fileProcessor.writeResultToFile(result);
                this.fileProcessor.writeResultToFile("\n");
                this.fileProcessor.writeResultToFile("\n");
                break;
            }
            case "FindClosestBook": {
                int bookID = getIntegerFromString(this.getParameters(line));
                List<Book> closestBooks = this.bookManager.findClosestBook(bookID);
                if (closestBooks.size() != 0) {
                    List<String> results = bookManager.generatePrintBooksResult(closestBooks);
                    printBooks(results);
                }
                break;
            }
            case "ColorFlipCount": {
                int result = this.bookManager.redBlackTree.getColorFlipCount();
                this.fileProcessor.writeResultToFile("Colour Flip Count: " + result + "\n\n");
                break;
            }
            case "Quit":
                this.fileProcessor.writeResultToFile("Program Terminated!!");
                this.fileProcessor.releaseFile();
                break;
            default:
                System.out.println("Unidentified Input!");
                break;
        }

    }

    private void printBooks(List<String> results) {

        for (String result : results) {
            this.fileProcessor.writeResultToFile(result);
            this.fileProcessor.writeResultToFile("\n");
        }

    }

    public void processCommands() {

        String command = "";
        while (!command.equals("Quit()")) {
            command = this.fileProcessor.getNextLineFromFile();
            this.parseCommand(command);
        }

    }

}
