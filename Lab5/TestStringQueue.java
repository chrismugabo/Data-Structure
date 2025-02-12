public class TestStringQueue {
    public static void main(String[] args) {
        // Create an instance of ArrayQueue
        ArrayQueue<String> queue = new ArrayQueue<>();

        // a. Adds AB, AC, AD, AE, AF to the queue
        queue.add("AB");
        queue.add("AC");
        queue.add("AD");
        queue.add("AE");
        queue.add("AF");

        // b. Prints the queue
        System.out.println("Queue after adding AB, AC, AD, AE, AF:");
        queue.printQueue();

        // c. Remove two elements from the queue
        queue.remove();
        queue.remove();

        // d. Prints the queue
        System.out.println("Queue after removing two elements:");
        queue.printQueue();

        // e. Add a new element AG to the queue
        queue.add("AG");

        // f. Prints the queue
        System.out.println("Queue after adding AG:");
        queue.printQueue();
    }
}
