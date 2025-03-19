import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {

    // Task 1: Convert a queue into a queue of single-element queues
    public static <T> Queue<Queue<T>> makeSingleItemQueues(Queue<T> items) {
        Queue<Queue<T>> result = new LinkedList<>();
        for (T item : items) {
            Queue<T> singleQueue = new LinkedList<>();
            singleQueue.add(item);
            result.add(singleQueue);
        }
        return result;
    }
    
    


    
    // Task 2: Merge two sorted queues into one sorted queue
    public static <T extends Comparable<T>> Queue<T> mergeSortedQueues(Queue<T> q1, Queue<T> q2) {
        Queue<T> merged = new LinkedList<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            T q1Head = q1.peek();
            T q2Head = q2.peek();
            if (q1Head.compareTo(q2Head) <= 0) {
                merged.add(q1.poll());
            } else {
                merged.add(q2.poll());
            }
        }
        // Add remaining elements from q1
        while (!q1.isEmpty()) {
            merged.add(q1.poll());
        }
        // Add remaining elements from q2
        while (!q2.isEmpty()) {
            merged.add(q2.poll());
        }
        return merged;
    }

    // Merge sort using the helper methods
    public static <T extends Comparable<T>> Queue<T> mergeSort(Queue<T> queue) {
        if (queue.isEmpty() || queue.size() == 1) {
            return new LinkedList<>(queue); // Return a copy to preserve original
        }
        Queue<Queue<T>> queues = makeSingleItemQueues(queue);
        while (queues.size() > 1) {
            Queue<T> first = queues.poll();
            Queue<T> second = queues.poll();
            Queue<T> merged = mergeSortedQueues(first, second);
            queues.add(merged);
        }
        return queues.isEmpty() ? new LinkedList<>() : queues.poll();
    }

    // Test the implementation
    public static void main(String[] args) {
        Queue<String> names = new LinkedList<>();
        names.add("Jay");
        names.add("Ali");
        names.add("Deepa");
        
        System.out.println("Original Queue: " + names);
        Queue<String> sortedNames = mergeSort(names);
        System.out.println("Sorted Queue: " + sortedNames);
        System.out.println("Original Queue After Sorting: " + names); // Should remain unchanged
    }
}