import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Method to compute the number of matching strings on the basis of the queries
    static int[] matchingStrings(String[] strings, String[] queries) {
         /* Create and fill HashMap */
        HashMap<String, Integer> map  = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }
        /* Integer array to store the results of the queries*/
        int result[] = new int[queries.length];
        /* Query HashMap */
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i], 0);
        }
        return result;
    }

    /* Driver Code */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] strings = new String[stringsCount];
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }
        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] queries = new String[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }
        int[] res = matchingStrings(strings, queries);
        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));
            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
