
/*
    - In this question there are 3 condition which we need to consider
        - We can jump from index i to index i+1 & i+2
        - when jumping from i to i+2 we need to see c[i+2] is safe cloud & i+2 is less than lenth of c
        - when above conditions are satisfied code we will jump to i+2 think this as we do in greedy questions
        - If any of the above condition is not satisfied we need to jump to i+1 because it is given solution always exist 
*/


import java.io.*;
import java.util.*;

public class solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        // for storing the number of jumps
        int jumps=0;
        // n stores length of array c
        int n=c.length;
        //loop traversing through given array c
        for(int i=0; i<n;){
            // checking whether jumping to i+2 is a valid move or not
            if(i+2<n&&c[i+2]==0){
                i=i+2;
                jumps++;
            }else{
                //when jumping only to i+1
                jumps++;
                i++;
            }
            if(i==n-1){
                // if we reached end we will come out of loop
                break;
            }
        }
        //return the number of jumps
        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt(); // length of array i.e. number of clouds
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n]; // array to store number of valid clouds

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem; // value of index in array
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
