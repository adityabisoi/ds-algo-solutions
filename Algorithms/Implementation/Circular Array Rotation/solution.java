import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt()%n;
        int q = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < q; i++){
            int m = sc.nextInt();
            if(m-k >=0)
            {
                System.out.println(a[m-k]);
            }
            else
            {
                System.out.println(a[n+(m-k)]);
            }
            
        }
    } 
}