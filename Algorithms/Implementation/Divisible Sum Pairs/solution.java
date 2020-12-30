// divisibleSumPairs in JAVA

/*
    This seems very hard question when read but due to constarints this can be done by applying bruteforce

    Traverse the array make possible pair of i & j such that j is always greater than i
*/

import java.io.*;
import java.util.*;

public class solution {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count=0; // to store count of such pairs
        //Traverse through the array
        for(int i=0;i<n; i++){
            int j=i+1;
            // make sure j is greater than i
            while(j<n){
                // if sum of elements present at index at i & j is divisible by k increase the count
                if((ar[i]+ar[j])%k==0){
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
