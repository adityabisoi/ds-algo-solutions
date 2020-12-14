import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    //Method to compute the number of operations required to increase the sweetness
    static int cookies(int k, int[] A) {
        //Creating a new priority queue and pushing
        //all the values in the queue
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0;i<A.length;i++)
        {
            queue.add(A[i]);
        }
        //Set count to zero
        int count=0;
        //Check if the first value in queue is less than k
        while(queue.peek()<k)
        {
            //If queue size is greater than or equal to 2
            if(queue.size() >= 2)
            {
                //remove the first and second values
                int x=queue.remove();
                int y=queue.remove();
                //in place of them put a new modified value
                y=x+2*y;
                queue.add(y);
                //Increment the count by 1
                count++;
            }
            //If queue size is less than 1 and the element is less than k return -1
            else
            {
                return -1;
            }
        }
        //Finally return the count
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0].trim());
        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];
        String[] AItems = scanner.nextLine().split(" ");
        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
