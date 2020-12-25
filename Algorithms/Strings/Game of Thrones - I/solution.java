import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
        // store the freqencies of each character in string
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            freq[str[i] - 97]++;
        }
        // if the string has even number of characters,
        // the frequency of each character should be even to get a palindrome
        if (str.length % 2 == 0) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 != 0)
                    return "NO";
            }
            return "YES";
            // if there are odd number of characters, only one character can have odd
            // number of occurences
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
