import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        // Read input from STDIN & Print output to STDOUT
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] sticks = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            sticks[i] = input.nextInt();
        }
        
        // QuickSort sticks array in ascending order
        // The built in sort function performs a dual pivot quick sort that rarely degrades to n^2
        Arrays.sort(sticks);
        
        int sticksLeft = n;
        
        int curr = sticks[0];
        int currCount = 0;
        System.out.println(n);
        
        //Works by decrementing sticksLeft by the frequency of the smallest stick each time
        for(int i = 0; i < n; i++)
        {
            if(curr == sticks[i])
            {
                currCount++;
            }
            else
            {
                sticksLeft -= currCount;
                currCount = 1;
                curr = sticks[i];
                System.out.println(sticksLeft);
            }
        }
        
        
    }
}