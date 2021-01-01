import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class solution {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER. The function accepts
     * INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here

        // sort the list
        Collections.sort(a);
        int start = 0;
        int i = 0;
        int ans = 0;
        while (i < a.size()) {

            // if the difference is greater than 1, move the start index to the position of
            // i
            if (Math.abs(a.get(start) - a.get(i)) > 1) {
                start = i;
            }
            // keep storing the max
            ans = Math.max(ans, i - start + 1);
            i++;
        }
        i--;

        return Math.max(ans, i - start + 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
