public class Ping {
    public static void main(String[] args) {
        int n = 500; // Example value for n

        // Pseudocode 1 Analysis
        long startTime1 = System.nanoTime();
        int totalPings1 = 0;
        for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= j + 1; k++) {
                totalPings1++;
            }
        }
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1) / 1_000_000; // Convert nanoseconds to milliseconds
        System.out.println("Total 'Ping' executions in Pseudocode 1: " + totalPings1);
        System.out.println("Execution time for Pseudocode 1: " + duration1 + " ms");

        // Pseudocode 2 Analysis
        long startTime2 = System.nanoTime();
        int totalPings2 = 0;
        int i = 1;
        while (i <= n) {
            totalPings2++;  // Ping in the outer loop
            int j = n;
            while (j > i) {
                totalPings2++;  // Ping in the inner loop
                j--;
            }
            i++;
            
        }
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2) / 1_000_000; // Convert nanoseconds to milliseconds
        System.out.println("Total 'Ping' executions in Pseudocode 2: " + totalPings2);
        System.out.println("Execution time for Pseudocode 2: " + duration2 + " ms");

        // Pseudocode 3 Analysis
        long startTime3 = System.nanoTime();
        int totalPings3 = 1; // Starting with one Ping
        i = 1;
        while (i <= n) {
            totalPings3++; // Ping in the outer loop
            int j = 1;
            while (j <= i * i) {
                totalPings3++;  // Ping in the inner loop
                j++;
            }
            i++;
        }
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3) / 1_000_000; // Convert nanoseconds to milliseconds
        System.out.println("Total 'Ping' executions in Pseudocode 3: " + totalPings3);
        System.out.println("Execution time for Pseudocode 3: " + duration3 + " ms");
    }
}



