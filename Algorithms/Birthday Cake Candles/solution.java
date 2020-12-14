import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    //Method to return the number of tallest candles
    public static int birthdayCakeCandles(List<Integer> candles) {
        // We will set the maxcount and max size of candle to zero
        int max = candles.get(0), maxCount = 1;
        // We will iterate through the array and update the tallest candle and its count 
        for(int i = 1; i < candles.size(); i ++) { 
            if(max  < candles.get(i)) 
            {
                max = candles.get(i);
                maxCount = 1;
            }
            else if(max == candles.get(i)) {
                maxCount ++;
            }
        }
        //Finally return the max Count
        return maxCount;
    }
}

/* Driver Code */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        int result = Result.birthdayCakeCandles(candles);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
