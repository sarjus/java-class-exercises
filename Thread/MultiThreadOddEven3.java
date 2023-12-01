/*
Write a Java program that implements a multi-threaded program which has three threads. 
First thread generates a random integer every 1 second. If the value is even, second thread 
computes the square of the number and prints. If the value is odd the third thread will print 
the value of cube of the number.
*/
import java.util.Random;

class NumberManager {
    private int generatedNumber;
    private boolean numberGenerated = false;

    // Method to generate a random number
    public synchronized void generateNumber() {
        // Generate a random number between 2 and 100
        generatedNumber = new Random().nextInt(99) + 2;
        System.out.println("Generated Number: " + generatedNumber);

        // Set the flag to indicate that the number has been generated
        numberGenerated = true;

        // Notify waiting threads that the number is ready
        notifyAll();
    }

    // Method for calculating the Square if the no is even
    public synchronized void caculateSquare() {
        try {
            // Wait until the number is generated and is even
            while (!numberGenerated || generatedNumber % 2 != 0) {
                wait();
            }
          
            System.out.println("The random number is even and it's squre is:"+generatedNumber*generatedNumber);

            // Reset the flag for the next iteration
            numberGenerated = false;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 // Method for calculating the Cube if the no is odd
    public synchronized void calculateCube() {
        try {
            // Wait until the number is generated and is odd
            while (!numberGenerated || generatedNumber % 2 == 0) {
                wait();
            }
            System.out.println("The random number is odd and it's cube is:"+generatedNumber*generatedNumber*generatedNumber);
           
            

            // Reset the flag for the next iteration
            numberGenerated = false;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NumberGenerator extends Thread {
    private NumberManager numberManager;

    public NumberGenerator(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        while (true) {
            // Generate a new number every 1 second
            numberManager.generateNumber();

            try {
                // Sleep for 1 second before generating the next number
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenSquareThread extends Thread {
    private NumberManager numberManager;

    public EvenSquareThread(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        while (true) {
            // Print even numbers and append to even.txt
            numberManager.caculateSquare();
        }
    }
}

class OddCubeThread extends Thread {
    private NumberManager numberManager;

    public OddCubeThread(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void run() {
        while (true) {
            // Print odd numbers and append to odd.txt
            numberManager.calculateCube();
        }
    }
}

public class MultiThreadOddEven3 {
    public static void main(String[] args) {
        // Create a shared instance of NumberManager
        NumberManager numberManager = new NumberManager();

        // Create instances of the three threads with the shared NumberManager
        NumberGenerator numberGenerator = new NumberGenerator(numberManager);
        EvenSquareThread EvenSquareThread = new EvenSquareThread(numberManager);
        OddCubeThread OddCubeThread = new OddCubeThread(numberManager);

        // Start the threads
        numberGenerator.start();
        EvenSquareThread.start();
        OddCubeThread.start();
    }
}
