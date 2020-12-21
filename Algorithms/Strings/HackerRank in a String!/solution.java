import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
    We will traverse through hackerrank till we reach end of it or we reach end of given string
    Now there will be traversing two condition
        1. First if we reach end of "hackerrank" string means hackerrank is present in the given string and hence answer would be yes
        2. Now if we reach end of given string s before reaching end of string "hackerrank" means there is no hackerrank as substring of string s
            hence answer would be no.
*/

public class solution {

    private static final String Code = "hackerrank";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); //number of testcases
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next(); // string in which we want to find hackerrank is substring or not
            
            int counter = 0; //stores index of character in hackerrank which is to be found
            // traversing through string s
            for(int i=0; i<s.length(); i++) {
                // if we find match to chracter in hackerrank increase the counter
                if(s.charAt(i)==Code.charAt(counter)) {
                    counter++; //increase the counter
                    if(counter==Code.length()) {
                        break; //if we have reached end of string "hackerrank" come out of loop
                    }
                }
            }
            //Print YES if we have reached the end of string declared as "hackerrank" else print NO
            System.out.println(counter==Code.length() ? "YES" : "NO"); 
        }
        in.close();
    }
}