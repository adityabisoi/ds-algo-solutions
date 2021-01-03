/*
    This problem is identical to standard nim game. 
    If the current player is in winning position and the opponent adds some chips, 
    the current player can remove those chips in his move and remain in winning position. 
    As the current player can mirror his opponent's "add" move all the time, that move has no value.
    Now you can find xor sum like standard nim game and determine who will win the game.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {

    public static void main(String[] args) throws IOException {
         Scanner sc = new Scanner(System.in);

       int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int b=0;
            while(n-->0)
            {
                b^=sc.nextInt();
            }

            if(b==0)
                System.out.println("Second");
            else
                System.out.println("First");
        }
    }
}
