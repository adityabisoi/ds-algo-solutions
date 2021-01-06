import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        b = b.toLowerCase();
        // we'll note if string has _ then we can swap places
        boolean canSwap = false;
        boolean isEmpty = true;
        // initialise char freq array
        int[] chars = new int[26];
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '_') {
                canSwap = true;
            } else {
                // note the char frequencies
                chars[((int) b.charAt(i)) - 97]++;
                isEmpty = false;
            }
        }
        // if the string is empty there are no unhappy lady bugs
        if (isEmpty) {
            return "YES";
        }
        // if there is only one ladybug we can't make it happy
        if (b.length() <= 1) {
            return "NO";
        }
        // if there exists only one ladybug of any color, we can't make them happy
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 1) {
                return "NO";
            }
        }
        // for i=0 if right ladybug is not of same color and we can't swap,return NO
        for (int i = 0; i < b.length(); i++) {
            if (i == 0) {
                if (b.charAt(i) != b.charAt(i + 1) && !canSwap) {
                    return "NO";
                }
                // for rightmost ladybug, if ladybug is not of same color and we can't swap
                // return NO
            } else if (i == b.length() - 1) {
                if (b.charAt(i) != b.charAt(i - 1) && !canSwap) {
                    return "NO";
                }
                // if adjacent ladybug is not of same color and we can't swap, return NO
            } else {
                if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1) && !canSwap) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
