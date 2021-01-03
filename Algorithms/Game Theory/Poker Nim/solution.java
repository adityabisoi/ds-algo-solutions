import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i=0; i<t; i++){
            int n = input.nextInt();
            int k = input.nextInt();
            int p = 0;
            for(int j=0; j<n; j++){
                int q = input.nextInt();
                p = p^q;
            }
            if(p==0){
                System.out.println("Second");
            }else{
                System.out.println("First");
            }
        }
    }
}