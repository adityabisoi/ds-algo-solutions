import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // maxMin function
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr); // Sorts the array in ascending order
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= arr.length - k; i++) 
            min = Math.min(min, arr[k + i - 1] - arr[i]); // Keeps a running min of the beginning and end of subarrays
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt(); // number of elements in array
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt(); // number of elements to select
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt(); 
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr); // calling maxMin function
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/*
 Time Complexity: O(n log(n))
 Space Complexity: O(1)         
*/
