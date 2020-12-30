import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int maxx=0;
        for(int i=0; i<height.length; i++){
            if(height[i]>maxx){
                maxx=height[i];
            }
        }
        maxx=maxx-k;
        if(maxx>0){
            return maxx;
        }
        return 0;
    }

    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int k = in.nextInt();

        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            int heightItem = in.nextInt();
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);
        System.out.print(result);
        in.close();
    }
}
