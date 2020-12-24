import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Method to compute the number of beautiful days within the given range
    static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        // Traverse through the range and check if the given day is beautiful
        for(int x = i; x <= j; x ++) {
            // Get the reverse of the number
            int revX = reverse(x);
            // Check if the absolute difference between 
            // x and reverse of x is divisible by k
            if(Math.abs(x - revX) % k == 0) {
                beautifulDays ++;
            }
        }
        // Finally return the number of beautiful days
        return beautifulDays;
    }
    
    // Method to compute the reverse of a number
    static int reverse(int x) {
        int rev = 0;
        // Extract the digits and store them in reverse order
        while(x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // Finally return the reversed number
        return rev;
    }

    // Driver code
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] ijk = scanner.nextLine().split(" ");
        int i = Integer.parseInt(ijk[0]);
        int j = Integer.parseInt(ijk[1]);
        int k = Integer.parseInt(ijk[2]);
        int result = beautifulDays(i, j, k);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
