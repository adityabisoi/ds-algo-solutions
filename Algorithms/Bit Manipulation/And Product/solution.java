import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the andProduct function below.
    static long andProduct(long a, long b) {
        // initialise result with a
        long res = a;
        for (long i = a + 1; i < b; i++)
            // use bitwise & operator for values ranging from a to b
            res = res & i;

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] ab = scanner.nextLine().split(" ");

            long a = Long.parseLong(ab[0]);

            long b = Long.parseLong(ab[1]);

            long result = andProduct(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
