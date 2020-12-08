import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // This method would return the count of pairs of socks
    static int sockMerchant(int n, int[] arr) {
        int countPairs = 0;
        //In this approach we would keep record of each sock by maintaining
        //a hash map that will store the sock number and its count in the array
        HashMap<Integer, Integer> hMap = new HashMap<>();
        //We would traverse through the sock array and update our hashMap
        for(int i = 0; i < arr.length; i ++) {
            if(hMap.containsKey(arr[i])) {
                hMap.put(arr[i], hMap.get(arr[i]) + 1);
            }
            else {
                hMap.put(arr[i], 1);
            }
        }
        //We will traverse through the hashmap and if count of 
        //any sock number is greater than 1 we will increment the count
        for(Map.Entry<Integer,Integer> x : hMap.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
            if(x.getValue() >= 2)
            {
                countPairs += x.getValue() / 2;
            }
        }
        //Finally we return the count of Pairs of Socks
        return countPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
