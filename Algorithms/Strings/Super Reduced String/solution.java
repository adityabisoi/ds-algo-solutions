import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // superReducedString function
    static String superReducedString(String s) {
        // StringBuffer is more efficient than String
        StringBuffer str = new StringBuffer(s);
        // iterate through string
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                str.delete(i-1, i+1); // deleting a pair of letter
                i = 0; // restarting
            }
        }
        // check for the string length
        if(str.length() == 0) 
            return "Empty String";
        else 
            return str.toString();
    }

    // main function
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
