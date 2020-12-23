import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] typeCounts = new int[5];
        //A loop for iterating over each type of bird
        for (int i = 0; i < n; i++) {
            int typ = in.nextInt();
            typeCounts[typ-1]++;
        }
        int maxCount = 0;
        int maxType = 0;
        //A loop for iterating over each type of bird
        //find the max out birds which belongs to one of the categories
        for (int i = 0; i < 5; i++) {
            if(typeCounts[i]>maxCount) {
                maxCount = typeCounts[i];
                maxType = i+1;
            }
        }
        System.out.println(maxType);
    }
}
