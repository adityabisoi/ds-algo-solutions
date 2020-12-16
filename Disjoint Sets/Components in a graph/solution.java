import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String args[]){
        int[] parents = new int[30001];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a, b;

        while(n-->0){

            a = sc.nextInt();
            b = sc.nextInt();

            if(parents[a] == 0) parents[a] = a;
            if(parents[b] == 0) parents[b] = a;

            //Disjoin set idea, keep updating the representative element of each set.
            if(parents[a] != 0 || parents[b] != 0){
                int low = Math.min(parents[a], parents[b]);
                int high = Math.max(parents[a], parents[b]);
                for(int i=0; i<parents.length; i++){
                    if(parents[i] == high)
                        //let representative always be the smallest in the set
                        parents[i] = low;
                }
            }
        }

        //convert int[] to Integer[] in order to use Collections.frequency(Integer[], int)
        Integer[] newArray = new Integer[parents.length];
        int i = 0;
        for (int value : parents) {
            newArray[i++] = value;
        }

        List<Integer> ints = Arrays.asList(newArray);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int item : newArray) {
            if(item != 0) {
                int frequency = Collections.frequency(ints, item);
                min = Math.min(min, frequency);
                max = Math.max(max, frequency);
            }
        }
        System.out.println(min + " " + max);
    }

}
