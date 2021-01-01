//String algorithms--> Two Characters

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

public class solution {

   
    static int alternate(String s) {
        
        if(s.length()<=1)  //base case
        return 0;
      int[][] pair = new int[26][26]; //choice of pairs of laternating characters
      int[][] count = new int[26][26]; //keeps track of the length possible for each pair of choice 

    for (int i = 0; i < s.length(); i++) {
      char letter = s.charAt(i);
      int letterNum = letter - 'a';

      // Updating the row corresponding to the current character
      for (int col = 0; col < 26; col++) {
        if (pair[letterNum][col] == letter) {
          count[letterNum][col] = -1;
        }
        if (count[letterNum][col] != -1) {
          pair[letterNum][col] = letter;
          count[letterNum][col]++;
        }
      }

     //  Updating column corresponding to the current character
      for (int row = 0; row < 26; row++) {
        if (pair[row][letterNum] == letter) {
          count[row][letterNum] = -1;
        }
        if (count[row][letterNum] != -1) {
          pair[row][letterNum] = letter;
          count[row][letterNum]++;
        }
      }
    }

    //Finding maxlen from "count" array
    int maxlen = 0;
    for (int row = 0; row < 26; row++) {
      for (int col = 0; col < 26; col++) {
        maxlen = Math.max(maxlen, count[row][col]);
      }
    }
   return maxlen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
