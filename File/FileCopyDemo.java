/******************************************************
 * File         :   FileCopyDemo.java
 * Description  :   Program to copy the data from one file to another
 * Author       :   Sarju S
 * Version      :   1.0
 * Date         :   20/11/2023
 * ***************************************************/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyDemo {

    public static void main(String[] args) {
        char[] data = new char[50];
        FileReader input = null;
        FileWriter output = null;
        try {
            // Open the FileReader for the existing file
            input = new FileReader("outputfile.txt");
            // Read data from the file into the char array
            int bytesRead = input.read(data);
            // Display the read data (assuming it is text)
            System.out.println(data);
            // Close the input file
            input.close();
            // Open the FileWriter for the new file
            output = new FileWriter("newoutput.txt");
            // Write the data to the new file
            output.write(data, 0, bytesRead);
            // Flush and close the output file
            output.flush();
            output.close();

        } catch (IOException e) {
            // Handle IO exceptions (e.g., file not found, permissions issue)
            e.printStackTrace();
        } 
    }
}
