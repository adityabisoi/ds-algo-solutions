import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.*;

public class Solution {

    // Complete the camelcase function below.
    
    //Camelcase words have all letters in first word as lowercase but the subsequent words start with uppercase. Hence , the number of words can be counted by simply counting the number of uppercase letters.
    
    static int camelcase(String s) {
        
        //First word has no uppercase letters , hence initially word count is one.
        int count_words = 1;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                count_words++;
            }
        }
        
    return count_words;
    
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
