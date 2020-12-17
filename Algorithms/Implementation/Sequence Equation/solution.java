//Q-->Sequence equation , algorithms(implementation)
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int[] permutationEquation(int[] p) {
       
       ArrayList<Integer> ll=new ArrayList<>();  //to store values
         for(int i = 0;i < p.length;i++)
        p[i]--; //decrementing p values by one according to indices
    
    // using double for loop we match for p(p(x))=y
    // first for x and second for y
    // as we have started from index 0, then we push index
     
    for(int i = 0; i < p.length; i++) {   //for y
        for (int j = 0; j < p.length; j++) { //for x
            if (p[p[j]] == i) {
                ll.add(j+1);
                break;
            }
        }
    }
    int ans[]=new int[ll.size()]; //ans array to be returned
    for(int i=0;i<ans.length;i++){
        ans[i]=ll.get(i);
    }
    return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

