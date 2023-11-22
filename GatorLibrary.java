
/**
 * This is the main function to call the controller.
 */
class GatorLibrary {

    public static void main(String args[]) {

        // Assuming the first parameter is the file name.
        Controller controller;
        if (args.length == 0) {
            System.out.println("Please enter a test case file name, e.g. java GatorLibary test1.txt");
        } else
            try {
                controller = new Controller(args[0]);
                controller.processCommands();
            } catch (FileProcessorException e) {
                e.printStackTrace();
            }
    }

}