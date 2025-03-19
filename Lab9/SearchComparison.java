import java.util.Random;

public class SearchComparison {

    public static void main(String[] args) {
        int size = 2_000_000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        Random rand = new Random();
        int target = rand.nextInt(size);

        System.out.println("Comparison of Linear Search and Binary Search");
        System.out.println("Target value is: " + target);

        // Linear Search
        long startTime = System.nanoTime();
        int linearIterations = linearSearch(array, target);
        long linearTime = System.nanoTime() - startTime;

        // Binary Search (Iterative)
        startTime = System.nanoTime();
        int binaryIterativeGuesses = binarySearchIterative(array, target);
        long binaryIterativeTime = System.nanoTime() - startTime;

        // Binary Search (Recursive)
        startTime = System.nanoTime();
        int[] result = {0}; // Array to hold the count for recursion
        binarySearchRecursive(array, target, 0, array.length - 1, result);
        long binaryRecursiveTime = System.nanoTime() - startTime;

        // Output results
        System.out.println("Linear search required " + linearIterations + " loop(s) to find the value");
        System.out.println("Binary search (Iterative) required " + binaryIterativeGuesses + " guess(es)");
        System.out.println("Binary search (Recursive) required " + result[0] + " guess(es)");
        System.out.println(binaryIterativeTime < linearTime ? "[Binary search is faster]" : "[Linear search is faster]");
        System.out.println("Time (ns) - Linear: " + linearTime + 
                         ", Iterative Binary: " + binaryIterativeTime + 
                         ", Recursive Binary: " + binaryRecursiveTime);
    }

    private static int linearSearch(int[] array, int target) {
        int iterations = 0;
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                return iterations;
            }
        }
        return -1; // Not found (should not happen here)
    }

    private static int binarySearchIterative(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int guesses = 0;

        while (low <= high) {
            guesses++;
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return guesses;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }

    private static boolean binarySearchRecursive(int[] array, int target, int low, int high, int[] count) {
        if (low > high) return false;

        count[0]++;
        int mid = low + (high - low) / 2;
        if (array[mid] == target) {
            return true;
        } else if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, high, count);
        } else {
            return binarySearchRecursive(array, target, low, mid - 1, count);
        }
    }
}