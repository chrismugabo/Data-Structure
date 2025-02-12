public interface Queue<E> {
    void add(E element); // Adds an element to the back of the queue
    E element();         // Returns the element at the front of the queue
    boolean isEmpty();   // Checks if the queue is empty
    E remove();          // Removes and returns the element at the front of the queue
    int size();          // Returns the number of elements in the queue
}
