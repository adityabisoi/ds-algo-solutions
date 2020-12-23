import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    static int minimumLoss(long[] price) {
        
        long min = Long.MAX_VALUE;
        //Hash mapping for easy access to indexes
        Map<Long, Integer> a = new HashMap<Long, Integer>();
        for (int index = 0; index < price.length; index++)
        {
            a.put(price[index], index);
        }
        //Sorting the original array
        Arrays.sort(price);
        for(int i=1;i<price.length;i++){
            //taking difference of the current element and the previous element
            long diff = price[i]-price[i-1];
            
            //if the difference is possitive and
            //if the previous index is greater than current index (from the Map a)
            if(a.get(price[i])<a.get(price[i-1]) && diff>0){
                min = Math.min(min, diff);
            }
        }
        return (int)min; //typecasting from long to int
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
