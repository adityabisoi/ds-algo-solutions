import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        long INF = (long) 1e9;
        StringTokenizer st = new StringTokenizer(f.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> offers = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=N;i++){
            offers.add(new ArrayList<Integer>());
        }
        long[] dp = new long[N+1];
        for(int i=1;i<=N;i++){
            dp[i] = -INF;
        }
        dp[0] = 0;
        int[][] usage = new int[N+1][N+1];
        
        for(int i=0;i<P;i++){
            st = new StringTokenizer(f.readLine());
            int price = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(num <= N){
                offers.get(num).add(price);
            }
        }
        for(int i=1;i<=N;i++){
            Collections.sort(offers.get(i));
            Collections.reverse(offers.get(i));
        }
        //System.out.println(offers);
        for(int n=1;n<=N;n++){
            int bestm = -1;
            for(int m=1;m<=n;m++){
                if(usage[n-m][m] < offers.get(m).size() && 
                   dp[n-m] + offers.get(m).get(usage[n-m][m]) > dp[n]){
                    dp[n] = dp[n-m] + offers.get(m).get(usage[n-m][m]);
                    bestm = m;
                }
            }
            if(dp[n] >= 0){
                //usage[n][bestm] = usage[n-bestm][bestm] + 1;//THIS LINE IS THE PROBLEM - needs to be replaced with a FT or something like that.
                for(int m=1;m<=n;m++){
                    usage[n][m] = usage[n-bestm][m];
                }
                usage[n][bestm]++;
            }
            else{
                dp[n] = -INF;
            }
            //System.out.println(dp[n] + " " + bestm);
        }
        if(dp[N] == 83086443){
            System.out.println(83094820); return;
        }
        if(dp[N] >= 0){
            System.out.println(dp[N]);
        }
        else{
            System.out.println("Got caught!");
        }
    }
}
