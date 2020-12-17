import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        int n=A.length, m = A[0].length;
        //area of upper and lower surfaces(sides) will be its projection i.e. n*m
        int area = 2*n*m;
        //to access all the 4 neighbors
        int[][] c = {{-1,0},
                     {0,-1},
                     {1,0},
                     {0,1}};
        //now we are left with 4 sides
        //let's go one by one through each coordinate
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                for(int[] t: c){
                    try{
                            //accessing the height of the side neighbor
                            int side = A[i+t[0]][j+t[1]];
                            //if it is less than the height of the current cell then 
                            //the surface area of this side is their height difference
                            if(A[i][j]>side)  area+=A[i][j]-side;
                        
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        //if this exception is raised that means this is a extreme cell
                        //and hence the area is equal to its height
                        area+= A[i][j];
                    }
                }
            }
        }
        return area;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
