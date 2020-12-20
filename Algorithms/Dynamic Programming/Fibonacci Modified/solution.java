import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {

        // since we are dealing with squares integer overflow may occur

        // that is why we use BigInteger here
        BigInteger a = new BigInteger(Integer.toString(t1));
        BigInteger b = new BigInteger(Integer.toString(t2));

        // if n==1 or n==0 the answer will be zero
        BigInteger c = new BigInteger("0");
        for (int i = 2; i < n; i++) {
            c = a.add(b.multiply(b));
            a = b;
            b = c;

        }
        return c;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
