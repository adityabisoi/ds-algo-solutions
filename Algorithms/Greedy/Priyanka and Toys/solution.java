/*
We can sort the toys ascending by weight,then we just iterate over it not counting when we get the next 4 consecutive weight toys for free

We have to sort the toys by weight, so -
Time Complexity: O(n log(n))
We store the input in a dynamically allocated array, so -
Space Complexity: O(n)
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int units = 1;
        
        //Initialize the array of toys
        int[] toys = new int[n];
        for(int i = 0; i < n; i++)
            toys[i] = sc.nextInt();
        
        //Sort the toys ascending by weight
        Arrays.sort(toys); 
        
        int currentWeight = toys[0];
        for(int weight : toys)
        {
            if(!(weight <= currentWeight+4))
            {
                units++;
                currentWeight = weight;
            }
        }
        
        System.out.println(units);
    }
}