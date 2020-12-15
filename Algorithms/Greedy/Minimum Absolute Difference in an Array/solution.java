import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  
    static int minimumAbsoluteDifference(int[] arr) {
        //n-stores length of array,diff is used to take out difference
        int i,j,diff,n=arr.length; 
        //taking a base minimum value for reference
        int min=(int)Math.abs(arr[0]-arr[1]);
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                //Math.abs takes out the absolute value and returns in double so we type cast it in int
                diff=(int)Math.abs(arr[i]-arr[j]);
                //if the diffrence is less than min it becomes the minimum value
                if(diff<min)
                min=diff;
            }
        }
    //returning the minimum value
     return(min);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    //printing element in array
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
    //getting result from function
        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
