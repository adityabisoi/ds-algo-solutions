import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts
     * INTEGER_ARRAY prices as parameter.
     */

    public static long stockmax(List<Integer> prices) {
        int n = prices.size();
        long maxSoFar = prices.get(n - 1), profit = 0;
        for (int i = n - 2; i >= 0; i--) {
            // if current price is greater than max,update max
            if (prices.get(i) > maxSoFar)
                maxSoFar = prices.get(i);
            else
                // profit will be after selling the stock at lower price
                profit += maxSoFar - prices.get(i);
        }
        return profit;
        // Write your code here

    }

}

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] pricesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> prices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesTemp[i]);
                prices.add(pricesItem);
            }

            long result = Result.stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
