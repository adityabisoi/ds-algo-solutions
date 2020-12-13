import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // In this approach basically we compute the bitwise difference and compute accordingly
    static long theGreatXor(long x) {
        // Set a to 1
        long a=1;
        // Keep Multiplying 2 to a till it is less than x
        while(a*2<=x)
        {
            a*=2;
        }
        // Find the difference between x and a
        long b=x-a;
        //Return the value obtained by subtracting b and 1 from a
        return a-1-b;
    }
    
    /* Driver Code */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            long x = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            long result = theGreatXor(x);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
