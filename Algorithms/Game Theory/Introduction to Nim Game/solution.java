import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the nimGame function below.
    static String nimGame(int[] pile) {
        int nim_sum = 0;
        // Here we can simply find the XOR sum and because both players play optimally
        // if nim sum is zero player 1 will win
        for (int i = 0; i < pile.length; i++) {
            nim_sum = nim_sum ^ pile[i];
        }
        if (nim_sum == 0)
            return "Second";
        return "First";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] pile = new int[n];

            String[] pileItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pileItem = Integer.parseInt(pileItems[i]);
                pile[i] = pileItem;
            }

            String result = nimGame(pile);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
