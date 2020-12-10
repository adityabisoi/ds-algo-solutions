import java.util.Scanner;
import java.util.ArrayList;

public class DynamicArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Input number of sequences
        int N = scan.nextInt();
        //Input number of queries
        int Q = scan.nextInt();
        //Initialize lastAns to zero
        int lastAns = 0;

        /* Create 2-D ArrayList */
        ArrayList<ArrayList<Integer>> lists = new ArrayList();
        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<Integer>());
        }

        /* Perform Q Queries */
        for (int i = 0; i < Q; i++) {
            //For each query input query number, x and y
            int q = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            //Compute the index
            int index = (x ^ lastAns) % N;
            //Get the sequence
            ArrayList<Integer> seq = lists.get(index);
            //If query is 1 add element y to the sequence
            if (q == 1) {
                seq.add(y);
            }
            //If query is 2 assign value of seq at y % size to lastAns and print out the value
            else if (q == 2) {
                lastAns = seq.get(y % seq.size());
                System.out.println(lastAns);
            }
        }
        scan.close();
    }
}