/*
    Very naive solution is applying O(n^2), will give TLE in most cases.
*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    static int solution(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance=c[0];
        for(int i=1; i<c.length; i++){
            int Distance=(c[i]-c[i-1])/2;
            if(Distance>maxDistance){
                maxDistance=Distance;
            }
        }
        int lastGap=(n-1)-c[c.length-1];
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

        int result = solution(n,c);
        System.out.println(result);
    }
}
