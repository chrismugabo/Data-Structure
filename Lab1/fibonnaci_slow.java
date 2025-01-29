package Lab1;

import java.math.*;
import java.io.*;
public class fibonnaci_slow
{

        private static BufferedReader stdin = new BufferedReader( new InputStreamReader( System.in ) );

	// This is the classic, recursive implementation of a function
	// that computed the nth Fibonacci number (given n)
        public static int fibonacci(int n)
        {
                if((n == 1) || (n == 2))
                        return 1;
                else
                        return fibonacci(n-1) + fibonacci(n-2);
        }


        public static void main(String[] args)
        {

                int n;
		long time, newTime, answer;
	
                // Prompt the user
                System.out.println("Type a positive integer." );
                try{

                        // Read a line of text from the user.
                        String input = stdin.readLine();

                        // converts a String into an int value
                        n = Integer.parseInt( input );
			
			time = System.currentTimeMillis();
			answer = fibonacci(n);
			newTime = System.currentTimeMillis();

                        System.out.println("The "+n+"th Fibonacci number is "+ answer);
                        System.out.println("It took " + (newTime-time) + " milliseconds to compute it.");
                }
                catch(java.io.IOException e)
                {
                        System.out.println(e);
                }

		

	} // end of main
	
} // end of class
