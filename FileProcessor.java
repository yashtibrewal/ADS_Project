
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * To process the files.
 */
public class FileProcessor {

    private File outputFile;
    private FileWriter fileWriter;
    private Scanner scanner;
    private String fileName;
    private static FileProcessor fileProcessor;

    private FileProcessor(String fileName) {
        String outputFileName = fileName.split("\\.")[0];
        outputFile = new File(outputFileName + "_output_file.txt");
        this.fileName = fileName;
        try {
            fileWriter = new FileWriter(outputFile);
            File file = new File(this.fileName);
            this.scanner = new Scanner(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static FileProcessor getFileProcessor() throws FileProcessorException{
        if(FileProcessor.fileProcessor == null){
            throw new FileProcessorException();
        }
        return FileProcessor.fileProcessor;
    }

    public static void initializeFileProcessor(String filePath){
        FileProcessor.fileProcessor = new FileProcessor(filePath);
    }

    public List<String> readFile() {

        File file = new File(this.fileName);
        List<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();

        } catch (FileNotFoundException exception) {
            // handle the Exception.
            exception.printStackTrace();
        }
        return lines;
    }

    public String getNextLineFromFile(){

        return scanner.nextLine();

    }

    public void writeResultToFile(String result) {

        try {
            fileWriter.write(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void releaseFile() {
        try {
            fileWriter.close();
            scanner.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
