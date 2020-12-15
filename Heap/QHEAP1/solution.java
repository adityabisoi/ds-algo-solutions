import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Using priority queue for heap implementation because priority queue is built on min-heap.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
        
        for(int i = 0; i < n; i++) {
            int q = sc.nextInt();
            switch(q) {
                case 1 : 
                    pq.add(sc.nextInt()); //Element has been added.
                    break;
                case 2 : 
                    pq.remove(sc.nextInt()); //Given element will be removed.
                    break;
                case 3 : 
                    System.out.println(pq.peek()); //Peek is used to see the top of min-heap.
                    break;
            }
        }
    }
    
}