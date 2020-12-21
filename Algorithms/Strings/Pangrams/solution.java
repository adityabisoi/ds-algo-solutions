import java.io.*;
import java.util.*;
import java.lang.*;

/*
  .indexOf(c) returns the index of 1st appearance of character c in string if that character is not in given string it return -1
  So we will traverse from a till z for any character s.indexOf returns -1 then string is not pangram we will stop the remaining execution
  On the otherhand if we reach till z and all characters are present in string then string is pangram
*/

public class solution {

    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        s = s.toLowerCase(); //converting all letters of string to lowercase
        for (char c = 'a'; c <= 'z'; c++)
        {
            // if value of s,indexOf returns -1 we will print "not pangram" and end the execution
            if (s.indexOf(c) == -1) 
            {
                System.out.println("not pangram");
                return;
            }
        }
        // if c value is greater than z we will "pangram" denotilg given string is pangram
        System.out.println("pangram"); 
        in.close();
    }
}
