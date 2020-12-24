import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // organizingContainers function
    static String organizingContainers(int[][] Box) {
        //Create a bag for the amount of  each ball and the sizes of containers
        LinkedList<Integer> containers = new LinkedList<>();
        LinkedList<Integer> balls = new LinkedList<>();
        for(int i = 0; i < Box.length; i++){
            int rowSum = 0;
            int colSum = 0;
            for(int j = 0; j < Box[0].length; j++){
                rowSum += Box[i][j]; 
                colSum += Box[j][i];
            }
            balls.add(colSum);
            containers.add(rowSum);
        }
            
        //Check if the two bags are equal
        containers.removeAll(balls);
        if(containers.isEmpty()) 
            return "Possible";
        else 
            return "Impossible";
    }


    private static final Scanner scanner = new Scanner(System.in);

    // mian function
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
