import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Basic Idea: the distribution will always be in the form 010101 (for sorted array)
     * if the distribution is equal as it will distribute almost equally to minimise their diff. 
     * but if the distribution is unequal i.e k!=n/2, then just add equall number of zeros on both the side
     * i.e. 000010101000 for ex. k=3 and the array is (1 2 3 4 5 6 7 8 9 10 11 12) 
     */
    static long fairCut(int k, int[] arr) {
        int n = arr.length;
        
        Arrays.sort(arr);
        long ans = 0;
        for(int i = 0, j = n; i < n / 2; i++) {
            //now we can ignore the middle 1's for the extra zeros we added because here |12-5| + |1-5| = 12-1
            // and this will be true for all the numbers in other set i.e. 5,7,9 i.e. k times the above value
            if(k <= j - k) {
                //typecasting is required as the value can be really big
                ans += (long)(arr[n - i - 1] - arr[i]) * k;
                j -= 2;
            }
            // similarly in the middle case we can make the following algo-->
            else {
                
                ans += (long)(arr[n - i - 1] - arr[i]) * (j - k);
                j -= 2;
                k -= 2;
            }
            System.out.println(ans);
        }
        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        long result = fairCut(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
