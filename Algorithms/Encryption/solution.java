import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        
        // remove spaces
        String noSpaces = s.replaceAll(" ","");
        // calculate length of no-spaced string
        double length = new Double(noSpaces.length()).doubleValue();
        //calculate rows as square root of length
        double rows = Math.floor(Math.sqrt(length));
        //columns should be 'rows+1' else 'rows' if rows is greater than sqrt(length)
        double columns = (rows>= Math.sqrt(length)) ? rows : rows +1;
        // define a new string builder
        StringBuilder result = new StringBuilder();
    
        // print the string in length of 'column' separated by spaces
        for(int j = 0; j < columns; j++){
            for(int i=j; i<length; i+=columns){
                result.append(noSpaces.charAt(i));
            }
            result.append(' '); // add space after each row in line
            
        }
        return result.toString().trim(); // convert to string and trim
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
