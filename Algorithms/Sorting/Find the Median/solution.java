import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // size of the array
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        // elements of array
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // sorting elements of array in ascending order
        Arrays.sort(arr);
        
        //then print the middle element(n/2) of array
        System.out.println(arr[(n/2)]);
    }
}

// Time Complexity: O(n log (n))
// Space Complexity: O(n)