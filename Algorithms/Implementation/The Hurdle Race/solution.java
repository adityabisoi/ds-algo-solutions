/*
    In this question we only need to maximum number, maxx in height array because
        - If character has to jump a hurdle of maxx he needs to drink minimum maxx-k potions to pass that particular hurdle
        - If maxx-k is less than zero or equal to zero no need to drink any potion
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int maxx=0; // To store maximum number in height array
        // Loop to get the maximum number in height array
        for(int i=0; i<height.length; i++){
            if(height[i]>maxx){
                maxx=height[i];
            }
        }
        maxx=maxx-k; // minimum potion to cross the hurdle of height maxx
        // now if maxx is less than or equal to zero no need to drink any potion character will jump all the hurdles easily
        if(maxx<=0){
            return 0;
        }
        return maxx; // If maxx is greater than zero than character needs to drink that maxx amount of potion
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
