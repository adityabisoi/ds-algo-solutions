import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            freq[str[i] - 97]++;
        }
        if (str.length % 2 == 0) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 != 0)
                    return "NO";
            }
            return "YES";
        } else {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 != 0)
                    count++;
            }
            if (count > 1)
                return "NO";
            else
                return "YES";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
