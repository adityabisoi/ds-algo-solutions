import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the towerBreakers function below.
    static int towerBreakers(int n, int m) {
        // every player wants to reduce tower height to 1 because 1 divides all numbers
        // evenly

        // if the heights of the tower is 1, player 1 has no moves hence player 2 wins
        if (m == 1)
            return 2;

        // so if odd number of towers, 1 gets to make the last move hence 1 wins and
        // vice-versa
        else {
            if (n % 2 == 0)
                return 2;
            else
                return 1;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = towerBreakers(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
