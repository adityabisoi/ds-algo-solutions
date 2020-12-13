//Question--> Find the running median in a stram of numbers passed as an array.
//median is the middle element in a data set(sorted), if the size of data set is odd 
//and it is the sum/2 of the two medians in case of even length.

/*Approach--> Here we make use of minheap and maxheap as two buckets which helps
to maintain the sorted order and get the middle elements.
Here we need to balance the heaps so that the maximum diff between lengths is <=1*/ 

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static double[] runningMedian(int[] a) {
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());//on peek gives max
        PriorityQueue<Integer> min=new PriorityQueue<>();//on peek gives min
        double ans[]=new double[a.length];
        for(int i=0;i<a.length;i++){
            int num=a[i];
            addnumber(num,max,min);  //adds the number to one of the two buckets 
            balance(max,min);        //balances the lengths
            if(max.size()>min.size()){
                ans[i]=(1.0)*max.peek();
            }
            else if(min.size()>max.size()){
                ans[i]=(1.0)*min.peek();
            }
            else{
                double v=(max.peek()+min.peek())/2.0;  //in case same lengths
                ans[i]=v;
            }
        }
        return ans;
        
    }
    static void addnumber(int n,PriorityQueue<Integer> max,PriorityQueue<Integer> min){
       if(max.size()==0||n<max.peek())
       max.add(n);
       else
       min.add(n);
    }
    static void balance(PriorityQueue<Integer> max,PriorityQueue<Integer> min){
        if(Math.abs(max.size()-min.size())>1)
        {
            if(max.size()>min.size()){
                min.add(max.poll());
            }
            else
            max.add(min.poll());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
