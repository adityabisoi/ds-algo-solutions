import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] toys = new int[n];
        for(int i = 0; i < n; i++)
        {
            toys[i] = input.nextInt();
        }
        
        Arrays.sort(toys);
        int totalToys = 0;
        
        for(int i = 0; i < n; i++)
        {
            k -= toys[i];
            if(k > 0) totalToys++;
            if(k <= 0) break;
        }
        System.out.println(totalToys);
    }
}