import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    public static void main(String[] args) {
        // The data to be written to the file
        String data = "This is the input to the file";

        // FileWriter object to write data to a file
        FileWriter output = null;

        try {
            // Create a FileWriter for the specified file path ("D:/outputfile.txt")
            output = new FileWriter("D:/outputfile.txt");

            // Write the data to the file
            output.write(data);

            // Flush any buffered data to the file
            output.flush();

            // Close the FileWriter to release system resources
            output.close();
        } catch (IOException e) {
            // Handle IO exceptions (e.g., file not found, permissions issue)
            e.printStackTrace();
        }
    }
}
