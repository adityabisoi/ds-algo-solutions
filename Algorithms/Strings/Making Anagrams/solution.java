import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int makingAnagrams(String s1, String s2) {
        int[] freqs1 = new int[26]; 
        int[] freqs2 = new int[26];
        int deletion = 0;
        
        for(int i = 0; i < s1.length(); i++)
            freqs1[s1.charAt(i)-'a'] = freqs1[s1.charAt(i)-'a'] + 1;
        for(int i = 0; i < s2.length(); i++)
            freqs2[s2.charAt(i)-'a'] = freqs2[s2.charAt(i)-'a'] + 1;
        
        for(int i = 0; i < 26; i++)
            deletion += Math.abs(freqs1[i] - freqs2[i]);
        
        return deletion;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
