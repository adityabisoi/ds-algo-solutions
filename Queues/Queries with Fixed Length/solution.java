
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {
    static int argMinFirst(ArrayList<Integer> maximums){
        int best = maximums.get(0);
        int bestIndex = 0;
        for(int i = 0; i != maximums.size(); ++i){
            if(maximums.get(i) < best){
                best = maximums.get(i);
                bestIndex = i;
            }
        }
        return maximums.get(bestIndex);
    }


    static ArrayList<Integer> calculateMaximums(int sequence[], int k)
    {
        Deque<Integer>  dequeWindow = new LinkedList<>();
        ArrayList<Integer> maximums = new ArrayList<>();

        // prefill the array with the first window

        for(int i = 0; i < (k-1); ++i){
            maximums.add(Integer.MAX_VALUE);
        }
        for (int i = 0; i < k; ++i)
        {
            while ( (!dequeWindow.isEmpty()) &&                       // not empty
                    (sequence[i] >= sequence[dequeWindow.getLast()])  // the element is not important
                    ){
                dequeWindow.pollLast();
            }
            dequeWindow.addLast(i);
        }

        // go through the rest of the windows
        for (int i = k; i < sequence.length; ++i)
        {
            // add current maximum value in the window
            maximums.add(sequence[dequeWindow.peekFirst()]);

            // Remove the elements which are out of this window
            while ( (!dequeWindow.isEmpty()) &&
                    (dequeWindow.peekFirst() <= i - k)){
                dequeWindow.pollFirst();  // Remove from front of queue
            }


            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ( (!dequeWindow.isEmpty()) && sequence[i] >= sequence[dequeWindow.getLast()])
                dequeWindow.pollLast();

            // Add current element at the rear of Qi
            dequeWindow.addLast(i);
        }

        // Print the maximum element of last window
        maximums.add(sequence[dequeWindow.peekFirst()]);
        return maximums;
    }

    public static void main(String[] args) {
        //
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); int Q= in.nextInt(); in.nextLine();

        // parse the sequence
        int[] sequence = new int[N];
        for(int i = 0; i != N; ++i){
            sequence[i] = in.nextInt();
        }
        in.nextLine();

        // parse the queries
        int[] queries = new int[Q];
        for(int i = 0; i != Q; ++i){
            queries[i] = in.nextInt();
        }

        // process all the queries
        for(int i = 0; i != queries.length; ++i){
            ArrayList<Integer> maximums = calculateMaximums(sequence, queries[i]);


            System.out.println((argMinFirst(maximums)));
        }

    }
}
