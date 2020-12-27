import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // the number of items in array
        int[] frequencies = new int[100];
        // array elements
        for(int i = 0; i < n; i++)
        {
            int num = sc.nextInt();
            frequencies[num] = frequencies[num] + 1;
        }
        
        // number of times every number from 0 through 99 appears in array 
        for(int i = 0; i < frequencies.length; i++)
        {
            System.out.print(frequencies[i]+" ");
        }
    }
}

// Time Complexity: O(n+k)
// Space Complexity: O(k)

