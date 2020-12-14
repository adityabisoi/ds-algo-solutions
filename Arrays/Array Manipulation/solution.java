import java.util.*;
 
public class test {
  
  public static void main(String args[]) {
    //declare a scanner to take input
    Scanner scan = new Scanner(System.in);
    //take input of the number of numbers and number of operations
    long n = scan.nextInt(), q = scan.nextInt();

    //declare a prefix sum array
    long pre[] = new long[(int)n+2];

    //Idea here is that if we are given l, r, val then we will add val to pre[l] and subtract val from pre[r+1];

    //At the end, we will run a loop and find the prefix sums, and that will actually be the final array
    for(int i = 0; i < q; i++) {
        int l, r, val;
        //take input of l, r, val;
        l = scan.nextInt();
        r = scan.nextInt();
        val = scan.nextInt();

        //add val to pre[l];
        pre[l] += val;

        //subtract val from pre[r+1];
        pre[r+1] -= val;
    }

    //find prefix sum of this array
    for(int i = 2; i <= n; i++) {
        pre[i] += pre[i-1];
    }

    //initialise answer to 0
    long ans = 0;

    //iterate over the array and keep updating answer
    for(int i = 1; i <= n; i++) {
        ans = Math.max(ans, pre[i]);
    }

    //print the answer
    System.out.println(ans);
  }
}
    
    
    
    
