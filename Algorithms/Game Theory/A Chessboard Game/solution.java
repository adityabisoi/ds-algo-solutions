import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the chessboardGame function below.
    static String chessboardGame(int x, int y) {
        // It can be observed that the pattern repeats every 4 rows
        x = x % 4;
        y = y % 4;
        // The idea is to leave the player in a non-winning situation
        // And it can be deduced after analysing a few cases
        if ((x == 0) || (x == 3) || (y == 0) || (y == 3))
            return "First";
        else
            return "Second";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            String result = chessboardGame(x, y);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
