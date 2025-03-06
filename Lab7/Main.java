import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task 1: Create the lists
        List<Integer> sequentiallyOrdered = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            sequentiallyOrdered.add(i);
        }

        List<Integer> partiallySorted = new ArrayList<>(sequentiallyOrdered);
        // Shuffle 5% of the list to make it partially sorted
        int shuffleCount = (int) (0.05 * 1000);
        for (int i = 0; i < shuffleCount; i++) {
            int index1 = (int) (Math.random() * 1000);
            int index2 = (int) (Math.random() * 1000);
            Collections.swap(partiallySorted, index1, index2);
        }

        List<Integer> randomlyShuffled = new ArrayList<>(sequentiallyOrdered);
        Collections.shuffle(randomlyShuffled);

        // Convert lists to arrays for sorting
        int[] sequentiallyOrderedArray = sequentiallyOrdered.stream().mapToInt(i -> i).toArray();
        int[] partiallySortedArray = partiallySorted.stream().mapToInt(i -> i).toArray();
        int[] randomlyShuffledArray = randomlyShuffled.stream().mapToInt(i -> i).toArray();

        // Task 2: Measure sorting time
        long startTime, endTime;

        // Insertion Sort
        startTime = System.nanoTime();
        SortingAlgorithms.insertionSort(sequentiallyOrderedArray.clone());
        endTime = System.nanoTime();
        long insertionSequentiallyOrderedTime = (endTime - startTime) / 1000000; // Convert to milliseconds

        startTime = System.nanoTime();
        SortingAlgorithms.insertionSort(partiallySortedArray.clone());
        endTime = System.nanoTime();
        long insertionPartiallySortedTime = (endTime - startTime) / 1000000;

        startTime = System.nanoTime();
        SortingAlgorithms.insertionSort(randomlyShuffledArray.clone());
        endTime = System.nanoTime();
        long insertionRandomlyShuffledTime = (endTime - startTime) / 1000000;

        // Quick Sort
        startTime = System.nanoTime();
        SortingAlgorithms.quickSort(sequentiallyOrderedArray.clone());
        endTime = System.nanoTime();
        long quickSequentiallyOrderedTime = (endTime - startTime) / 1000000;

        startTime = System.nanoTime();
        SortingAlgorithms.quickSort(partiallySortedArray.clone());
        endTime = System.nanoTime();
        long quickPartiallySortedTime = (endTime - startTime) / 1000000;

        startTime = System.nanoTime();
        SortingAlgorithms.quickSort(randomlyShuffledArray.clone());
        endTime = System.nanoTime();
        long quickRandomlyShuffledTime = (endTime - startTime) / 1000000;

        // Merge Sort
        startTime = System.nanoTime();
        SortingAlgorithms.mergeSort(sequentiallyOrderedArray.clone());
        endTime = System.nanoTime();
        long mergeSequentiallyOrderedTime = (endTime - startTime) / 1000000;

        startTime = System.nanoTime();
        SortingAlgorithms.mergeSort(partiallySortedArray.clone());
        endTime = System.nanoTime();
        long mergePartiallySortedTime = (endTime - startTime) / 1000000;

        startTime = System.nanoTime();
        SortingAlgorithms.mergeSort(randomlyShuffledArray.clone());
        endTime = System.nanoTime();
        long mergeRandomlyShuffledTime = (endTime - startTime) / 1000000;

        // Display results
        System.out.println("Time taken (in milliseconds):");
        System.out.println("+---------------------+---------------------+---------------------+---------------------+");
        System.out.println("| List Type           | Insertion Sort      | Quick Sort          | Merge Sort          |");
        System.out.println("+---------------------+---------------------+---------------------+---------------------+");
        System.out.printf("| Randomly Shuffled   | %-20d| %-20d| %-20d|\n", insertionRandomlyShuffledTime, quickRandomlyShuffledTime, mergeRandomlyShuffledTime);
        System.out.printf("| Partially Sorted    | %-20d| %-20d| %-20d|\n", insertionPartiallySortedTime, quickPartiallySortedTime, mergePartiallySortedTime);
        System.out.printf("| Sequentially Ordered| %-20d| %-20d| %-20d|\n", insertionSequentiallyOrderedTime, quickSequentiallyOrderedTime, mergeSequentiallyOrderedTime);
        System.out.println("+---------------------+---------------------+---------------------+---------------------+");
    }
}