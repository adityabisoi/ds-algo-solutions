/*
    Very naive solution is applying O(n^2), will give TLE in most cases.

    So, instead of going from 1 to n i.e. visiting all the cities

    Consider all the cities to be a chain. 
    
    Ex, with 8 cities, it would look like this 0-1-2-3-4-5-6-7-8.
    Now, each space station will break the chain. 
    What we are trying to achieve are chains of cities without space stations. 
    If we have stations in 2 and 6, we just take them out. 
    We are left with three chains here. 0-1, 3-4-5, 7-8

    We just find the longest chain and the answer would be (length+1)/2. 
    This is the length from the middle of the chain to a station.

    This has two speacial cases when
     - When stations are not at beginining and at end cities i.e. 1 & n
     - See solution for details
*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    static int function(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance=c[0]; //dealing with 1st special case
        for(int i=1; i<c.length; i++){
            int Distance=(c[i]-c[i-1])/2;
            if(Distance>maxDistance){
                maxDistance=Distance;
            }
        }
        int lastGap=(n-1)-c[c.length-1]; //dealing with second case i.e. when space station is not at n-1
        return (lastGap < maxDistance) ? maxDistance : lastGap;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int m = in.nextInt();

        int[] c = new int[m];

        for (int i = 0; i < m; i++) {
            int a;
            a=in.nextInt();
            c[i] = a;
        }

        int result = function(n,c);
        System.out.println(result);
        in.close();
    }
}
