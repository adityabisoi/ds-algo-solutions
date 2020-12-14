import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i = 0; i < n; i++) {
            int q = sc.nextInt();
            switch(q) {
                case 1 : 
                    pq.add(sc.nextInt());
                    break;
                case 2 : 
                    pq.remove(sc.nextInt());
                    break;
                case 3 : 
                    System.out.println(pq.peek());
                    break;
            }
        }
    }
    
}