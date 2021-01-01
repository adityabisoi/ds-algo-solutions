import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;

        for (int i = 0; i < java.lang.Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i))
                commonLength++;
            else
                break;
        }
        // need a bigger k to transform s to t or vice versa
        if ((s.length() + t.length() - 2 * commonLength) > k) {
            return "No";
        }
        // we have exactly k moves so if k is odd number of distinct digits should be
        // odd too
        else if ((s.length() + t.length() - 2 * commonLength) % 2 == k % 2) {
            return "Yes";
        }
        // deletion of any one string and addition of characters of other string
        else if ((s.length() + t.length() - k) < 0) {
            return "Yes";
        }

        else {
            return "No";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
