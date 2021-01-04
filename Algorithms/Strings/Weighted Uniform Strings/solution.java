// String algorithms--> Weighted Uniform Strings

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    
    static String[] weightedUniformStrings(String s, int[] queries) {
         
         Set<Integer> set=new HashSet<>();  //set for frequency of each uniform substring of s

         for(int i=0;i<s.length();){
             char c=s.charAt(i);
             int j=i;
             int count=0;
             while(j<s.length()&&s.charAt(j)==c){
             count++;
             j++;
             }
             int val=c-96;  //weight of each character
             int temp=val;
             while(count-->0){
                 set.add(temp);
                 temp+=val;
             }
             i=j;
             
         }
         String res[]=new String[queries.length]; //result array
         for(int j=0;j<res.length;j++){
             if(set.contains(queries[j]))  //check if the set contains the query value
             res[j]="Yes";
             else
             res[j]="No";
             
         }
         return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}