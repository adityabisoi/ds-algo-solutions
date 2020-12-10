import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] keyboards = new Integer[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        
        // If we sort one in descending and the other in ascending 
        Arrays.sort(keyboards, Collections.reverseOrder());// Descending order
        Arrays.sort(drives);// Ascending order 
        
        int max = -1;
        for(int i = 0, j = 0; i < n; i++){
            for(; j < m; j++){
                if(keyboards[i]+drives[j] > b) break; // This prevents j from incrementing
                if(keyboards[i]+drives[j] > max)
                    max = keyboards[i]+drives[j];
            }
        }
        System.out.println(max);
    }
}

// Time Complexity: O(n+m(log(n+m)))  
// Space Complexity: O(1)
