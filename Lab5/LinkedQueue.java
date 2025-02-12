public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head = new Node<>(); // Dummy node
    private int size;

    // Adds an element to the back of the queue
    public void add(E element) {
        head.prev = head.prev.next = new Node<>(element, head.prev, head);
        ++size;
    }

    // Returns the element at the front of the queue
    public E element() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return head.next.element;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Removes and returns the element at the front of the queue
    public E remove() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        E element = head.next.element;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return element;
    }

    // Returns the number of elements in the queue
    public int size() {
        return size;
    }

    // Prints the queue
    public void printQueue() {
        System.out.print("[");
        Node<E> current = head.next;
        while (current != head) {
            System.out.print(current.element);
            if (current.next != head) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    // Node class for the linked list
    public static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        // Dummy node constructor
        Node() {
            this.prev = this.next = this;
        }

        // Node constructor with element, previous, and next references
        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
