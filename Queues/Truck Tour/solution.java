import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//make a class to contain both the features of a petrolpump
class Pair{
    public int capacity;
    public int dist;
}
public class Solution {

    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petrolpumps) {
        
        Queue<Pair> q = new LinkedList<Pair>();
        //adding each node of petrolpumps to the queue 'q'
        for(int i=0;i<petrolpumps.length;i++){
            Pair temp = new Pair();
            temp.capacity = petrolpumps[i][0];
            temp.dist = petrolpumps[i][1];
            q.offer(temp);
        }
        //start-> index of the petrolpump from where to start
        //current-> index w.r.t. start index
        //petrol-> net petrol left in the tank
        int current=0, start=0, petrol=0;
        while(current<petrolpumps.length){
            Pair temp = q.poll();
            petrol += temp.capacity;
            
            //if petrol left is less than the distance to travel
            if(petrol<temp.dist){
                //update the start index to the next node
                start += current+1;
                //set current index and net petrol to zero
                current=0;
                petrol=0;
                
            }
            else{
                //if we have enough petrol then set the net petrol for the next node
                petrol-=temp.dist;
                current++;
            }
            //insert this node to the end of the queue
            q.offer(temp);
        }
        
        return start;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
