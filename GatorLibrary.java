
class GatorLibrary {

    public static void main(String args[]) {

        // Assuming the first parameter is the file name.
        Controller controller;
        try {
            controller = new Controller(args[0]);
            controller.processCommands();
        } catch (FileProcessorException e) {
            e.printStackTrace();
        }
    }

}