/******************************************************
 * File         :   FileReaderDemo.java
 * Description  :   Program to read the contents from a file
 * Author       :   Sarju S
 * Version      :   1.0
 * Date         :   20/11/2023
 * ***************************************************/
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

    public static void main(String[] args) {
        // Array to store the read characters
        char[] data = new char[29];

        // FileReader object to read from a file
        FileReader input = null;

        try {
            // Create a FileReader for the specified file path ("outputfile.txt")
            input = new FileReader("outputfile.txt");

            // Read characters from the file into the char array
            int bytesRead = input.read(data);

            // Print the read data (assuming it is text)
            System.out.println(data);

        } catch (IOException e) {
            // Handle IO exceptions (e.g., file not found, permissions issue)
            e.printStackTrace();
        } finally {
            try {
                // Close the FileReader to release system resources
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                // Handle any exception that occurs during closing resources
                e.printStackTrace();
            }
        }
    }
}
