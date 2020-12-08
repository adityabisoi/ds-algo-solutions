import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //This method will compute the number of times
    //BestScore was broke and WorstScore was broke
    static int[] breakingRecords(int[] scores) {
        //Set bestScore and worstScore to first value of scores array
        int bestScore = scores[0], worstScore = scores[0];
        //Set count of bestScoreinc and worstscoredec to zero 
        int countBestScoreInc = 0, countWorstScoreDec = 0;
        //Traverse throught the remaining array
        for(int i = 1; i < scores.length; i ++) {
            //if bestScore is broken
            //Update bestScore and increase count by 1
            if(scores[i] > bestScore) {
                bestScore = scores[i];
                countBestScoreInc ++;
            }
            //if worstScore is broken 
            //Update worstScore and decrease count by 1
            if(scores[i] < worstScore) {
                worstScore = scores[i];
                countWorstScoreDec ++;
            }
        }
        //Finally return the count of bestScoreInc and worstScoreDec
        return new int[]{countBestScoreInc, countWorstScoreDec};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
