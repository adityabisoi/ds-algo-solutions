import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class result {

    // main function
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of elements in array a
        int m = in.nextInt(); // the number of elements in array b
        int[] a = new int[n];
        // taking elements of array a
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // taking elements of array a
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        // sort both arrays in increasing order
        Arrays.sort(a);
        Arrays.sort(b);
        int min = a[0];
        int max = b[b.length-1];
        int count=0;
        for(int i=min;i<=max;i++){
            if(hasFactors(i,a) && isFactor(i,b)){
                count++;
            }
        }
        // number of integers that are between the sets
        System.out.println(count);
    }
    
    // hasFactors function
    public static boolean hasFactors(int num, int[] arr){
        // check if elements of array are factor of num
        for(int i=0;i<arr.length;i++){
            if(num%arr[i]!=0){
                return false;
            }
        }
        return true;
    }
   
   // isFactor function
    public static boolean isFactor(int num, int[] arr){
        // check if your num is factor
        for(int i=0;i<arr.length;i++){
            if(arr[i]%num!=0){
                return false;
            }
        }
        return true;
    }
}