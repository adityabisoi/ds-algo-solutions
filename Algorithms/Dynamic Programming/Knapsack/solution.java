import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the unboundedKnapsack function below.
    private static int[][] ans;

    public static int solve(int k, int[] arr, int n) {

        if (k == 0 || n == 0)
            return 0;

        // if we have previously stored answer for the problem, return that
        if (ans[n][k] != -1)
            return ans[n][k];

        // if greater than the target sum reduce the problem size
        if (arr[n - 1] > k)
            return solve(k, arr, n - 1);

        // store the maximum out of the current and previous
        return ans[n][k] = Math.max(arr[n - 1] + solve(k - arr[n - 1], arr, n), solve(k, arr, n - 1));
    }

    static int unboundedKnapsack(int k, int[] arr) {
        int n = arr.length;
        ans = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                // initialise matrix with -1
                ans[i][j] = -1;
            }
        }

        return solve(k, arr, n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();

        for (int y = 0; y < t; y++) {

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = unboundedKnapsack(k, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}