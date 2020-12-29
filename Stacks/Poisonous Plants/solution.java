import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // pair class which contains val and count
    static class Pair {
        int val, count;
        public Pair(int val, int count) { // constructor
            this.val = val;
            this.count = count;
        }
    }

    // poisonousPlants function using stack
    static int poisonousPlants(int[] p) {
        Stack<Pair> stack = new Stack<>();
    int cnt = 0;
    // traversing from end to starting point
    for (int i = p.length - 1; i >= 0; i--) {
        int temp = 0;
        while (!stack.empty() && p[i] < stack.peek().val) {
            // if stack is not empty and stack peek is less than element of array
            temp++;
            Pair pair = stack.pop();
            temp = Math.max(temp, pair.count); // maximum of temp and count
        }
        cnt = Math.max(cnt, temp); // maximum of cnt and temp
        stack.push(new Pair(p[i], temp)); // push new pair
    }

    return cnt;

    }

    private static final Scanner scanner = new Scanner(System.in);

    // main function
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt(); // the size of the array
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n]; // integer array

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p); // function call

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
