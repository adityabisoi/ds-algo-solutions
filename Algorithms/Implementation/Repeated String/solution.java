/*
    Understanding question
        - We need to return number of 'a' prsent in when string s is multiplied to form a string of length atlaest n
    Solution - We will calculate number of 'a' present in strng s without appending s to it's end
             - So once we have calculated that s contains say x a initially so then this just a unitary method question
                if say string length is m then m contains x a's so n length dtring s will contain (x*n)/m
             - There might be a case when n is not divisible by m and leaves remainder k
             - Then we will traverse upto k in string s and add number of a in string s upto length k

             
*/

import java.io.*;
import java.util.*;

public class solution {

    static long repeatedString(String s, long n) {
        // count stores the number of a's in string s initially
        long count=0; 
        int i=0;
        // Calculating number of a's in string s initially
        while(i<s.length()){
            // When we encounter a in s increase count by one
            if(s.charAt(i)=='a'){
                count++;
            }
            i++;
        }
        // div is n/m as stated above
        long div=n/s.length();
        count=count*div;
        //When n is not evenly divisible by m so we will traverse upto k in string s 
        // for k refer top comment section
        if(div*s.length()!=n){
            long rem=n-div*s.length(); //k
            i=0;
            while(i<rem){
                // Increase count when we encounter a in s
                if(s.charAt(i)=='a'){
                    count++;
                }
                i++;
            }
        }
        //return the number of count of in s
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
