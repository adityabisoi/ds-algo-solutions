import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Implemetation Part
    static String isValid(String s) {
        // using hashmap which contains -> (char, frequency)  
        // if key is not present then put it with freqency = 1
        // else increase it's frequency by 1   
              
        Map<Character, Integer> frequencies = new HashMap<>();
        
        for(char letter : s.toCharArray())
        {
            if(frequencies.containsKey(letter))
                frequencies.put(letter, frequencies.get(letter) + 1);
            else
                frequencies.put(letter, 1);
        }
        
        // set not consider duplicate values
        // so inserting all frequencies to a set valid 
        Set<Integer> st = new HashSet<>();
        for(int freq : frequencies.values())
        {
            st.add(freq);
        }
        
        // if size of set > 2 then string is not 
        // if size = 1 then valid
        if(st.size() > 2)
             return ("NO");
        else if(st.size() == 1)
            return ("YES");
        else
        {
            // different cases for size = 2
            int f1 = 0, f2 = 0, f1Count = 0, f2Count = 0, i = 0;
            for(int n : st)
            {
                if(i == 0) f1 = n;
                else f2 = n;
                i++;
            }
            
            // counting all number of frequencies, f1 nad f2
            for(int freq : frequencies.values())
            {
                if(freq == f1) f1Count++;
                if(freq == f2) f2Count++;
            }
            
            // if frequency count and fequency both = 1, then valid 
            // if count = 1 and difference is also = 1 then it is valid
            // for another cases it is not valid
            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                return ("YES");
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                return ("YES");
            else
                return ("NO");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

