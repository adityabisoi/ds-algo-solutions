/*
    During each move, a player chooses one prime number and removes it (as well as its multiples) from the set. 
    Because a player cannot move unless there is at least one prime number in the set and a single prime number is removed during each turn,
     we simply need to count the number of primes in the inclusive range . 
     If the number of primes is odd, Alice will remove the last prime number and win the game;
      otherwise, this number is even and Bob will choose the last prime number, winning the game.

    You can get a 50% score if you generate prime numbers using a naive method. 
    For a full score, you should use a Sieve of Eratosthenes algorithm.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {
    static int sieve(int grens){
        int primes = 0;
        boolean[] catch_the_sieve = new boolean[grens+1];
        for (int x = 2; x <= grens; x++){
            if (catch_the_sieve[x] == false){
                primes++;
                for (int i = x; i <= grens; i += x){
                    catch_the_sieve[i] = true;
                    }
                }
            }
        return primes;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            //    System.out.println(sieve(n));
            if(sieve(n) % 2 == 0)
                System.out.println("Bob");
            else
                System.out.println("Alice"); 
        }
    }
}