public class ArrayQueue<E> implements Queue<E> {
    private E[] elements; // Array to store elements
    private int front;    // Index of the front element
    private int back;     // Index of the next available position
    private static final int INITIAL_CAPACITY = 5; // Default capacity

    // Constructor with default capacity
    public ArrayQueue() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        front = 0;
        back = 0;
    }

    // Constructor with custom capacity
    public ArrayQueue(int capacity) {
        elements = (E[]) new Object[capacity];
        front = 0;
        back = 0;
    }

    // Adds an element to the back of the queue
    public void add(E element) {
        if (size() == elements.length - 1) { // Check if the array is full
            resize(); // Double the array size
        }
        elements[back] = element; // Add the element
        back = (back + 1) % elements.length; // Wrap around if necessary
    }

    // Returns the element at the front of the queue
    public E element() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return elements[front];
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return front == back;
    }

    // Removes and returns the element at the front of the queue
    public E remove() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        E element = elements[front]; // Get the front element
        elements[front] = null; // Clear the reference
        front = (front + 1) % elements.length; // Wrap around if necessary
        return element;
    }

    // Returns the number of elements in the queue
    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return elements.length - front + back;
        }
    }

    // Resizes the array when it's full
    private void resize() {
        int newCapacity = elements.length * 2; // Double the capacity
        E[] newElements = (E[]) new Object[newCapacity];
        int size = size();
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length]; // Copy elements
        }
        elements = newElements;
        front = 0;
        back = size;
    }

    // Prints the queue
    public void printQueue() {
        System.out.print("[");
        String str = "";
        if (front <= back) {
            for (int i = front; i < back; i++) {
                str += elements[i] + ",";
            }
        } else {
            for (int i = front; i < elements.length; i++) {
                str += elements[i] + ",";
            }
            for (int i = 0; i < back; i++) {
                str += elements[i] + ",";
            }
        }
        if (str.length() != 0) {
            str = str.substring(0, str.length() - 1); // Remove the trailing comma
        }
        System.out.print(str + "]\n");
    }
}