//Q->Find digits, -->Given an integer, for each digit that makes up the integer determine whether 
//it is a divisor. Count the number of divisors occurring within the integer.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int findDigits(int n) 
    {
        int t=n;
        int count=0;  //ans to be returned i.e the count of the digits that divides the number
        while(t>0)
        {
            int r=t%10;  //getting the last digit
            if(r!=0){
            if(n%r==0)   //checking if it divides n
            count++;
            }
            t=t/10;      //reducing by 1/10
        }

        return count;    //returning the ans


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}