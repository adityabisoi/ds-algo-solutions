import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] a) {
        
        int c[] = new int[n];
        Arrays.fill(c,1); //First fill the array with 1 candy.
        
        /*
        Traverse the array from left to right and apply the required condition
        */
        for(int i=1;i<n;i++)
        {
            if(a[i]>a[i-1])
            {
                c[i] = c[i-1]+1;
            }
        }
        
        /*
        Now traverse the array from right to left and apply the required condition
        */
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>a[i+1])
            c[i] =Math.max(c[i+1]+1 , c[i]);
        }
        
        long sum = 0;
        for(int i=0;i<n;i++)
        {
            sum = sum + (long)(c[i]); // Sum of total candies.
        }
        
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
