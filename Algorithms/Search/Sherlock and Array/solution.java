import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i=0; i<k; i++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = in.nextInt();
            }
            System.out.println(decision(arr));
        }
    }
    
    public static String decision(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i]; //sum stores the total array sum
        }
        
        //curr is cimulated sum in the left
        int curr = 0;
        for(int j=0; j<arr.length; j++){
            //left part equals right part
            if(curr == sum - arr[j]-curr){ //sum - arr[j]-curr gives us the right part sum
                return "YES";
            }
            curr += arr[j];
        }
        return "NO";
    }
}