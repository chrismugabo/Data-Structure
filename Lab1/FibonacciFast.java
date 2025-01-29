package Lab1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciFast {
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    private static BigInteger[] memo;  // Array for memoization

    // Initialize the memoization array with null values
    private static void initializeMemo(int size) {
        memo = new BigInteger[size + 1];
        for (int i = 0; i <= size; i++) {
            memo[i] = null;
        }
        memo[0] = BigInteger.ZERO;  // Fibonacci(0)
        if (size > 0) {
            memo[1] = BigInteger.ONE;  // Fibonacci(1)
        }
    }

    // This method computes the nth Fibonacci number using memoization to avoid redundant calculations
    public static BigInteger fibonacci(int n) {
        if (memo[n] != null) {
            return memo[n];  // Return memoized result if already computed
        }
        // Recursively calculate only if not already in memo
        memo[n] = fibonacci(n - 1).add(fibonacci(n - 2));
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println("Type a positive integer.");
        try {
            String input = stdin.readLine();  // Read a line of text from the user.
            int n = Integer.parseInt(input);  // Converts String to int

            // Initialize memo array with enough space to store results up to n
            initializeMemo(n);

            long startTime = System.currentTimeMillis();
            BigInteger answer = fibonacci(n);  // Compute Fibonacci number using memoization
            long endTime = System.currentTimeMillis();

            System.out.println("The " + n + "th Fibonacci number is " + answer);
            System.out.println("It took " + (endTime - startTime) + " milliseconds to compute it.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
