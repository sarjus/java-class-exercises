// OddThread class extending Thread for printing odd numbers
class OddThread extends Thread {
    // Run method to be executed when the thread starts
    public void run() {
        // Loop to print odd numbers from 1 to 9
        for (int i = 1; i < 10; i += 2) {
            // Print the current odd number
            System.out.println(i + " ");
        }
    }
}

// EvenThread class extending Thread for printing even numbers
class EvenThread extends Thread {
    // Run method to be executed when the thread starts
    public void run() {
        // Loop to print even numbers from 2 to 8
        for (int i = 2; i < 10; i += 2) {
            // Print the current even number
            System.out.println(i + " ");
        }
    }
}

// Main class for running the threads
public class MultiThreadDemo {
    public static void main(String[] args) {
        // Create instances of OddThread and EvenThread
        OddThread odd = new OddThread();
        EvenThread even = new EvenThread();

        // Start the threads
        odd.start();
        even.start();

    }
}
