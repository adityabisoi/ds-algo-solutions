import java.util.*;

public class Solution {
    
    public static int getNumberOfWays(int n, int d, int m, int[] sum) {
        // Modify array to make each 'i' contain the running sum of prior elements
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
        }
        
        // Set number of ways counter
        // If there are >= 'm' squares AND the first possible piece has sum = 'd', 1
        // Else, 0
        int numberOfWays = (m <= n && sum[m - 1] == d) ? 1 : 0;
        
        // Check the sums for pieces ending at index 'm' through 'n - 1'
        for (int i = m; i < n; i++) {
            // If the sum of the piece is equal to 'd'
            if (sum[i] - sum[i - m] == d) {
                // Increment ways counter
                numberOfWays++;
            }
        }
        
        return numberOfWays;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] squares = new int[n];
        for(int squares_i=0; squares_i < n; squares_i++){
            squares[squares_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        in.close();

        System.out.println(getNumberOfWays(n, d, m, squares));
    }
}