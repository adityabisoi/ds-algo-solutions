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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
      
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
     
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
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
        System.out.println(count);
    }
    
    public static boolean hasFactors(int num, int[] arr){
        for(int i=0;i<arr.length;i++){
            if(num%arr[i]!=0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isFactor(int num, int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%num!=0){
                return false;
            }
        }
        return true;
    }
}