import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        for (int i = 0; i < 26; i++) {
            freq1[i] = 0;
        }
        for (int i = 0; i < str1.length; i++) {
            freq1[str1[i] - 97]++;
        }
        for (int i = 0; i < str2.length; i++) {
            if (freq1[str2[i] - 97] != 0) {
                return "YES";
            }
        }

        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
