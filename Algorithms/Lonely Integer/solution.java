import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // The method would return the unique value in the array
    // O(n) runtime. O(1) space. Uses XOR. Keep in mind:
    //   1) x ^ x = 0
    //   2) x ^ 0 = x
    //   3) XOR is commutative and associative
    static int lonelyinteger(int[] a) {
        // We would XOR all the numbers in the array
        // Only the unique number would be left
        int val = 0;
        for (int num : a) {
            val = val ^ num; // ^ is XOR operator
        }
        return val;
    }
    
    /* Driver Code */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        int result = lonelyinteger(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
