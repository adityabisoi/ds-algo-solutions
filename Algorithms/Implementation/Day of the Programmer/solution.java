import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        // only 12, 13 and 26 are possibled dates with month = september
        String date = "";
        // Julian check for leap year
        if (year < 1918) {
            date += (year % 4 == 0) ? "12.09." + year : "13.09." + year;
            // case:transition year
            // specific year as 13 less days from normal year
        } else if (year == 1918) {
            date += "26.09." + year;
            Gregorian check for leap year
        } else {
            date += ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) ? "12.09." + year : "13.09." + year;
        }
        return date;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
