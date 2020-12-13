import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    //Method to find parent of the current node
    static int find(int node, int[] parent) {
        while(parent[node]>=0)
            node=parent[node];
        return node;
    }
    // Method to find the lower bound for the target node
    static int lower_bound(int target, long[][] dp) {
        // Set left to zero and right to the length of dp 
        int left=0;
        int right=dp.length-1;
        // Reach the half with value closer to the target
        while(left<=right) {
            int middle=(left+right)>>1;
            if(dp[middle][0]>=target)
                right=middle-1;
            else
                left=middle+1;
        }
        //Return the lower bound of the half containing the target value
        return left;
    }
    
    static long[] solve(int[][] tree, int[][] queries) {
        // cost value from low to high
        Arrays.sort(tree, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });

        TreeMap<Integer, Long> map=new TreeMap<Integer, Long>();
        // Create a parent array to keep record of parent of each node
        int[] parent=new int[tree.length+2];
        // Initially set all the elements as -1
        Arrays.fill(parent, -1);
        //Traverse through the nodes and call the find function for each node
        for(int i=0; i<tree.length; i++) {
            int u=find(tree[i][0], parent);
            int v=find(tree[i][1], parent);
            int cost=tree[i][2];
            long number1=-parent[u];
            long number2=-parent[v];
            //Find the possible cost
            map.put(cost, map.getOrDefault(cost, new Long(0))+number1*number2);
            if(parent[u]>parent[v]) {
                parent[v]+=parent[u];
                parent[u]=v;
            }
            else{
                parent[u]+=parent[v];
                parent[v]=u;
            }
        }
        //Set total sum as zero
        long totalSum=0;
        int index=1;
        //Create a dp for the cost
        long[][] dp=new long[map.size()+1][2];
        dp[0][0]=dp[0][1]=0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            totalSum+=entry.getValue();
            dp[index][0]=entry.getKey();
            dp[index][1]=totalSum;
            ++index;
        }
        //Run the queries and extract the values from dp
        long[] result=new long[queries.length];
        long max=dp[dp.length-1][0];
        for(int i=0; i<queries.length; i++) {
            int left=lower_bound(queries[i][0], dp)-1;
            int right=lower_bound(queries[i][1], dp);
            if(right>=dp.length)
                --right;
            if(dp[right][0]>queries[i][1])
                --right;
            result[i]=dp[right][1]-dp[left][1];
        }
        //Finally return the result array
        return result;
    }
    /* Driver Code */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nq = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        int[][] tree = new int[n-1][3];
        for (int treeRowItr = 0; treeRowItr < n-1; treeRowItr++) {
            String[] treeRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int treeColumnItr = 0; treeColumnItr < 3; treeColumnItr++) {
                int treeItem = Integer.parseInt(treeRowItems[treeColumnItr]);
                tree[treeRowItr][treeColumnItr] = treeItem;
            }
        }
        int[][] queries = new int[q][2];
        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr]);
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }
        long[] result = solve(tree, queries);
        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));
            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
