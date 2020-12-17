import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //declaring static variables which will be same for all the test cases
    static long M = 1000000007;
    static boolean[] f = new boolean[8200];
    static ArrayList<Integer> P= new ArrayList<Integer>();

    // Complete the primeXor function below.
    static int primeXor(int[] a, long[] cnt) {
        //to store the count of subsets
        long[][] dp = new long[1005][8200];
            
        dp[0][3500] = (cnt[0] + 1)/2;
        dp[0][0] = (cnt[0] + 2) / 2;

        for(int i=1; i<1005; i++){
            //check all the values upto 8200
            for(int j=0; j<8200; j++){
                // it may give you ArrayIndexOutOfBoundsException to avoid it use try catch
                try{
                dp[i][j] = (dp[i-1][j]*((cnt[i]+2)/2) + dp[i-1][(j^(i+3500))]*((cnt[i]+1)/2) ) % M ;
                }
                catch(ArrayIndexOutOfBoundsException e){}
            }
        }
        long ans = 0;
        for(int p : P){
            ans += dp[1004][p];
            //take modulo of the large values
            ans %= M;
        }
        return (int)(ans%M);

    }
    //function to make all the numbers till 8200 (round of for 8192 i.e. 2^13) prime
    //As the xor-sum of any subset of array elements will not exceed 8191
    static void makePrime(){
        f[0] = f[1] = true;
        for(int i=2; i*i < 8200; i++){
            if(!f[i]){
                for(int j=i+i; j< 8200; j+=i)
                    f[j] = true;
            }
        }
        for(int i=2; i<8200; i++) if(!f[i]) P.add(i);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        makePrime();

        for (int qItr = 0; qItr < q; qItr++) {
            long[] cnt = new long[1005];
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
                cnt[a[i]-3500]++;
            }

            int result = primeXor(a, cnt);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
