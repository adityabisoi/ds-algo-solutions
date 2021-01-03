/*
    
    Imagine each tower as a Nim pile which has a Nimvalue equal to the number of prime factors of hi.
     Reducing a tower to its divisor is the same as taking away a non-zero prime factor from it.

    Thus, this game is the same as a Nim game and our answer is the XOR of all Nim piles. 
    If the Nim sum is 0, then player 2 wins;
     otherwise, player 1 wins.

*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class solution {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        //sieve of eratosthenes : precomputing prime numbers
         boolean isPrime[]=new boolean[10000000+1];
            for(int k=2;k<=10000000;k++)
                isPrime[k]=true;
            for(int factor=2;factor*factor<=10000000;factor++){
                if(isPrime[factor]){
                    for(int j=factor;j*factor<=10000000;j++)
                        isPrime[j*factor]=false;
                }
            }
        while(t-->0){
            int n=sc.nextInt();int val=0;
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                int count=0;
                if(isPrime[a[i]])
                    count=1;
                else{
                for(int k=2;k<=a[i];k++)
                    if(isPrime[k]){
                    if(a[i]%k==0){
                        a[i]=a[i]/k;
                        k=k-1;
                        count++;
                    }
                }
                }
                    val^=count;
            }
            if(val!=0) System.out.println("1");
            else System.out.println("2");
        }
    }
}
