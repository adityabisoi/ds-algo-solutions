import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int special = 0;
        int page = 1;
        int index = 0;
        // for every problem number check if it is equal to the page number
        for (int prob : arr) {
            for (int i = 1; i <= prob; i++) {
                if (i == page) {
                    special++;
                }

                index++;
                // when number of problems are more than k, we go to the next page
                if (index == k) {
                    page++;
                    index = 0;
                }
            }
            // when problems from a chapter finish, we move to the next page
            if (index != 0) {
                page++;
                index = 0;
            }
        }
        return special;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
