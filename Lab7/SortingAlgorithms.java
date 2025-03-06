public class SortingAlgorithms {

    // Insertion Sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            // Move elements of array[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Quick Sort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
        // Base case.
        if (begin >= end) return;
        // Partition the array.
        int pivot = partition(array, begin, end);
        // Recursively sort the two partitions.
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    // Partition part of an array, and return the index where the pivot ended up.
    private static int partition(int[] array, int begin, int end) {
        int pivot = array[begin]; // Choose the first element as the pivot
        int low = begin + 1;
        int high = end;

        while (low <= high) {
            // Find the first element greater than the pivot
            while (low <= high && array[low] <= pivot) {
                low++;
            }
            // Find the first element smaller than the pivot
            while (low <= high && array[high] > pivot) {
                high--;
            }
            // Swap the elements
            if (low < high) {
                swap(array, low, high);
            }
        }
        // Swap the pivot with the high index
        swap(array, begin, high);
        return high;
    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Merge Sort
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    // Merge Sort part of an array
    private static void mergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(array, begin, mid); // Sort the left half
            mergeSort(array, mid + 1, end); // Sort the right half
            merge(array, begin, mid, end); // Merge the two halves
        }
    }

    // Merge two sorted subarrays
    private static void merge(int[] array, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;

        // Merge the two halves into the temp array
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // Copy remaining elements from the left half
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // Copy remaining elements from the right half
        while (j <= end) {
            temp[k++] = array[j++];
        }

        // Copy the merged elements back into the original array
        for (i = begin, k = 0; i <= end; i++, k++) {
            array[i] = temp[k];
        }
    }
}