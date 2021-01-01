import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the misereNim function below.
    static String misereNim(int[] s) {
        int n = s.length;
        // if there is only 1 pile AND it has more than 1 element => First player wins
        if (n == 1) {
            return s[0] > 1 ? "First" : "Second";
        }
        int total = s[0];
        int xor = s[0];

        for (int i = 1; i < n; i++) {
            total += s[i];
            xor ^= s[i];
        }
        /*
         * If sum of all stones equals the total piles, all piles have a single (1)
         * stone. For even number of piles, first player will always win.
         */
        if (total == n) {
            return total % 2 == 0 ? "First" : "Second";
        }
        /*
         * For all other cases, the xor value determines winner. If xor value = 0, then
         * second player will always win as all piles (stones) can be paired.
         */
        return xor > 0 ? "First" : "Second";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] s = new int[n];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int sItem = Integer.parseInt(sItems[i]);
                s[i] = sItem;
            }

            String result = misereNim(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
