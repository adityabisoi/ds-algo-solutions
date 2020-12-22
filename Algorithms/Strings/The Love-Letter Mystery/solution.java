import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // theLoveLetterMystery function
    static int theLoveLetterMystery(String s) {
        int count = 0;
        int i = 0; // pointer at starting of string s
        int j = s.length() - 1; // pointer at end of string s

        // check for palindromic string
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                count += Math.abs(((int) s.charAt(i)) - ((int) s.charAt(j)));
            }
            i++; j--;
        }
        
        // minimum number of operations corresponding to each test case
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    // main function
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt(); // number of queries
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine(); // string

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
