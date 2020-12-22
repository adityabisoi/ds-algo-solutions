/*
We could use a greedy approach and starting from the
left everytime we see a 010 replace the last 0 with a 1
and continue
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // Read input from STDIN and Print output to STDOUT
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // length of binary string
        input.nextLine();
        String s = input.nextLine(); // single binary string of length n
        int switches = 0;
        
        for(int i = 0; i < s.length()-2; i++) // left to right character of binary string
        {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '1' && s.charAt(i+2) == '0')
            {
                switches++;
                i += 2;
            }
        }
        // minimum number of steps needed to make the string beautiful
        System.out.println(switches);
    }
}