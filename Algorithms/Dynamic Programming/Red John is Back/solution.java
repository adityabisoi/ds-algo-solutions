import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the redJohn function below.
    public int redJohn(int n) {
        // solve if n >= 4
        if (n < 4)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        func(dp, n);
        return noOfPrimes(dp[n]);
    }

    public int noOfPrimes(int n) {
        if (n < 2)
            return 0;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false; // mark 0 as non - prime number
        prime[1] = false; // mark 1 ass non- prime number
        // logic is any starting true marked boolean is prime 2 3 5 so on
        int count = 0; // count the number of prime till n;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                count++;
                for (int j = 2; j <= n / i; j++)
                    prime[j * i] = false;
            }
        }
        return count;

    }

    public int func(int[] dp, int n) {
        if (dp[n] > 0)
            return dp[n];

        dp[n] = func(dp, n - 1) + ((n > 3) ? func(dp, n - 4) : 0);
        return dp[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            Solution obj = new Solution();
            int result = obj.redJohn(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
