/*
There is no point in winning unimportant contests, so we can just lose all of them and get their luck.
Let's denote the number of important contests as C. If C<=K , we can just lose all of them and add their luck to our luck balance. 
If C>K , we want to win the K preliminary competitions having the smallest luck value. 
To do this, we sort all the luck values and subtract the first K values from our luck balance.
*/


// Importing required Packages
import java.io.*;
import java.util.*;


// Class Solution Intialization
public class Solution {

    // Declartion of Main Function
    public static void main(String[] args) {
        // Scanner object creation
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int k = in.nextInt();
      int ret = 0;
      List<Integer> imp = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        int l = in.nextInt();
        int t = in.nextInt();
        if (t == 0) ret += l;
        else {
          imp.add(l);
        }
      }
      Collections.sort(imp);
      for (int i = 0; i < imp.size(); i++) {
        if (i < imp.size() - k) {
          ret -= imp.get(i);
        } else {
          ret += imp.get(i);
        }
      }
      System.out.println(ret);
    }
}
