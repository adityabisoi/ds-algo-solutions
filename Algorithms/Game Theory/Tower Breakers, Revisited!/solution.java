import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 1001;
        int[] noOfPrimeFactors = new int[size];
        int[] primesList = new int[168];
        computeNoOfPrimeFactors(noOfPrimeFactors, size, primesList);
        noOfPrimeFactors[1] = 0;
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int p = 0;
            for(int j=0; j<n; j++){
                int q = sc.nextInt();
                if(q<=1000)
                    p = p^noOfPrimeFactors[q];
                else{
                    p = p^getNoOfPrimeFactors(q, noOfPrimeFactors, primesList);
                }
                    
            }
            if(p==0){
                System.out.println(2);
            }else{
                System.out.println(1);
            }
        }
    }

    public static void computeNoOfPrimeFactors(int[] mem, int n, int[] primes){
        Arrays.fill(mem,1);
        for(int i=4; i<n; i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
                    mem[i] = 1+mem[i/j];
                    break;
                }
            }
        }
        
        int count = 0;
        for(int i=2;i<n;i++){
            if(mem[i]==1){
                primes[count++] = i;
            }
        }
    }
    
}