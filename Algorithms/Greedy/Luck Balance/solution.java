import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
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
