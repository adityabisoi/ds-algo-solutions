import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        //ans[0] to store maximum topics and ans[1] to store its frequency
        int[] ans= new int[2];
        //next to loops is to permutate pair of attendies
        for(int i=0;i<topic.length-1;i++){
            for(int j=i+1;j<topic.length;j++){
                int t=0;
                //accessing each character in the string
                for(int k=0;k<topic[0].length();k++){
                    //if atleast one is 1 then incresing the value of t by 1
                    if(topic[i].charAt(k)=='1' || topic[j].charAt(k)=='1'){
                        t++;
                    }
                }
                //if there is another pair with same max value then increse the frequency by 1
                if(ans[0]==t){
                    ans[1]++;
                }
                //if this is not max then update it and set frequency as 1
                else if(ans[0]<t){
                    ans[0]=t;
                    ans[1] = 1;
                }
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
