import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Taking input the number of elements in the array.
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        
        String [] temp = line.split(" ");
        int [] arr = new int[n];
        
        //Taking input all the elements of an array.
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        
        //To find the minimum difference between adjacent numbers , firstly the array is sorted.
        Arrays.sort(arr);
        
        int min_diff = Integer.MAX_VALUE;
        
        //For loop to determine the minimum difference between adjacent elements.
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]<min_diff)
                min_diff= arr[i+1]-arr[i];
            
        }
        
        //For loop to print the array elements with minimum difference .
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]==min_diff){
                System.out.print(arr[i]+" "+arr[i+1]+" ");   
            }
        }
        
        
    }//Main() function ends.
    
}//Class ends.
