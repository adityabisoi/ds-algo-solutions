import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of elements in the integer array
        int k = sc.nextInt()%n;// because every n rotations we receive the same array
        int q = sc.nextInt(); // number of queries
        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = sc.nextInt();
        }
        
        
        //Run each query q
        for(int i = 0; i < q; i++){
            int m = sc.nextInt(); // index of an element in array to return
            //Checks if array wrap occurs
            if(m-k >=0)
            {
                System.out.println(a[m-k]);
            }
            else
            {
                //if array rap occurs then
                System.out.println(a[n+(m-k)]);
            }
            
        }
    } 
}