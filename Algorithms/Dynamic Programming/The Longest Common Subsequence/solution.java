import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // backTrack function
    public static String backTrack(int[][] arr, int[] arr1, int[] arr2, int n, int m)
    { 
        if(m == 0 || n == 0) // having no element
            return "";
        else { // having elements
            if(arr1[n] == arr2[m])
                return backTrack(arr, arr1, arr2, n-1, m-1) + " " + arr1[n];
            else {
                if(arr[n-1][m] > arr[n][m-1])
                    return backTrack(arr, arr1, arr2, n-1, m); // recursive call
                else
                    return backTrack(arr, arr1, arr2, n, m-1); // recursive call
            }
        }
    }
    
    // main function
    public static void main(String[] args) {
        // Read input from STDIN. Print output to STDOUT.
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // length of arr1
        int m = in.nextInt(); // length of arr2
        int[] arr1 = new int[n+1];
        int[] arr2 = new int[m+1];
        int[][] arr = new int[n+1][m+1];
        in.nextLine();
        String string = new String(in.nextLine());
        String[] str = string.split(" ");
        for (int i = 1; i <= n; i++) { // arr1
            arr1[i] = Integer.parseInt(str[i-1]);
        }
        string = in.nextLine();
        str = string.split(" ");
        for (int i = 1; i <= m; i++) { // arr2
            arr2[i] = Integer.parseInt(str[i-1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(arr1[i] == arr2[j])
                    arr[i][j] = arr[i-1][j-1] + 1;
                else {
                    if(arr[i-1][j] > arr[i][j-1])
                        arr[i][j] = arr[i-1][j];
                    else
                        arr[i][j] = arr[i][j-1];
                }
            }
        }
        
        // calling backTrack function
        System.out.println(backTrack(arr, arr1, arr2, n, m).substring(1));
        
    }
}
