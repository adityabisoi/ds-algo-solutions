import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Method to compute the value of XOR sequence
    static long xorSequence(long l, long r) {
        //The answer is the xor of value obtained by calc function of left and right range
        long answer = calc(r) ^ calc(l - 1);
        return answer;
    }
    //Perform xor of 7 with the limit passed and return on the basis of the conditions
    private static long calc(long limit) {
        switch ((int) (limit & 7)) {
            case 0:
                return limit;
            case 1:
                return limit;
            case 2:
                return 2;
            case 3:
                return 2;
            case 4:
                return limit + 2;
            case 5:
                return limit + 2;
            case 6:
                return 0;
            case 7:
                return 0;
            default:
                throw new RuntimeException();
        }
    }
    /* Driver Code */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");
            long l = Long.parseLong(lr[0]);
            long r = Long.parseLong(lr[1]);
            long result = xorSequence(l, r);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
