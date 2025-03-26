import java.util.Scanner;

public class MapString {
    private static final int TABLE_SIZE = 100;
    private static String[] stringBuckets = new String[TABLE_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("a. Add a string to the hashtable");
            System.out.println("b. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    System.out.print("Enter a string to add: ");
                    String input = scanner.nextLine();
                    addString(input);
                    break;
                case "b":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Adds a string to the hash table using linear probing for collision resolution.
     * @param s The string to be added.
     */
    private static void addString(String s) {
        int hash = calculateHash(s);
        boolean inserted = false;

        // Check from hash index to 99 for an empty slot
        for (int i = hash; i < TABLE_SIZE; i++) {
            if (stringBuckets[i] == null) {
                stringBuckets[i] = s;
                inserted = true;
                System.out.println("String added at index " + i);
                break;
            }
        }

        if (!inserted) {
            System.out.println("Error: No available position from index " + hash + " to 99.");
        }
    }

    /**
     * Calculates the hash index for a string.
     * @param s The input string.
     * @return The hash index (0-99).
     */
    private static int calculateHash(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += (int) c;
        }
        return sum % TABLE_SIZE;
    }
}