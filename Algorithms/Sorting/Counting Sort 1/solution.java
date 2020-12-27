import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] frequencies = new int[100];
        for(int i = 0; i < n; i++)
        {
            int num = sc.nextInt();
            frequencies[num] = frequencies[num] + 1;
        }
         
        for(int i = 0; i < frequencies.length; i++)
        {
            System.out.print(frequencies[i]+" ");
        }
    }
}
