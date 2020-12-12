import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    /*
    XOR represents binary addition without the "carry" for each digit. We want to see
    how many values of x that will give us n+x = n^x, which is when XOR is the same as
    ADDITION. This happens when there are no "carries". To make sure there are no
    carries, for each digit in "n" that is a 1, we must have the corresponding digit in
    "x" be a 0. For each digit in "n" that is a 0, we can have the corresponding digit 
    in "x" be either 0 or 1. Now we calculate the number of possibilities for "x" by 
    counting the number of 0s in "n" (up to the most significant 1 in n), and doing 
    2^(number of 0s) (where ^ is exponentiation in this case) to count all combinations.
    **/
    static long sumXor(long n) {
    /* Calculate number of "x" values that will satisfy n+x = n^x */
        int zeroes = numZeroes(n);
        return 1L << zeroes; // same as (long) Math.pow(2, zeroes);
    }
    private static int numZeroes(long n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                count++;
            }
            n >>= 1; // divides by 2
        }
        return count;
    }
    /* Driver Code */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        long n = Long.parseLong(bufferedReader.readLine().trim());
        long result = sumXor(n);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
