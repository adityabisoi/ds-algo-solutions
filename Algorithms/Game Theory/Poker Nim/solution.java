import java.io.*;
import java.util.*;

public class Solution {

    // main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        for(int i=0; i<t; i++){
            int n = sc.nextInt(); // the number of piles
            int k = sc.nextInt(); // the maximum number of times an individual player can add chips to some pile i
            int p = 0;
            for(int j=0; j<n; j++){
                int q = sc.nextInt();
                p = p^q; // power
            }
            if(p==0){
                System.out.println("Second");
            }else{
                System.out.println("First");
            }
        }
    }
}