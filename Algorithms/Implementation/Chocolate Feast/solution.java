//Q--> Chocolate Feast , Algorithms(Implementation)

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   
    static int chocolateFeast(int n, int c, int m) {
        
       int count=n/c;  //let count be the number of bars which is initially we have
                        //by spending n amount
       int wr=count;   //  initial wrappers

       while(wr>=m){   //loop until wrapper are atleast m
          int f=wr/m;
          count+=f;
          wr=wr-m*f;   //subtract number of wrappers we spent
          wr+=f;       //add number of wrappers we get from the bars purchased
       }
       return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
