import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // getMinimumCost function 
    static int getMinimumCost(int k, int[] c) {
        int[] friends = new int[k];
        for(int i = 0; i < k; i++) 
            friends[i] = c.length / k;
        for(int i = 0; i < c.length % k; i++) 
            friends[i] += 1;
        
        // sort all flower prices in ascending order
        Arrays.sort(c);
        int sum = 0, idx = 0;
        while(idx < c.length) {
            // Calculate total 
            for(int j = 0; j < k; j++) {
                if(friends[j] > 0) 
                    sum += (--friends[j] + 1) * c[idx++];
            }
        }       
        return sum; // minimum cost to buy all n flowers.
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    // main function
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]); // number of flowers

        int k = Integer.parseInt(nk[1]); // number of friends

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
