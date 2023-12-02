package sjcet.s3.practise;
import java.util.LinkedList;

class DoublyLinkedList<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Add an element to the end of the list
    public void add(T element) {
        list.addLast(element);
    }

    // Insert an element at a specific position in the list
    public void insert(int index, T element) {
        list.add(index, element);
    }

    // Remove an element at a specific position from the list
    public void remove(int index) {
        list.remove(index);
    }

    // Display the elements of the list
    public void display() {
        for (T element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        // Adding elements to the doubly linked list
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);

        System.out.println("Doubly Linked List elements:");
        doublyLinkedList.display();

        // Inserting an element at a specific position
        doublyLinkedList.insert(1, 5);

        System.out.println("Doubly Linked List after inserting at index 1:");
        doublyLinkedList.display();

        // Removing an element at a specific position
        doublyLinkedList.remove(2);

        System.out.println("Doubly Linked List after removing at index 2:");
        doublyLinkedList.display();
    }
}

