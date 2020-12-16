/* For an element in A, if there's a matching element in B, this creates a "beautiful pair". 
   Each element can only be used once to create a beautiful pair.
   Additionaly, We MUST change exactly 1 element in B. We attempt to change it to create 
   1 more beautiful pair. In the special case where we already have the max number of 
   beautiful pairs, being forced to change it gives us 1 less beautiful pair.

   Time Complexity: O(n)
   Space Complexity: O(1)
*/

import java.util.Scanner;

public class Solution {
    
    private static final int Max_Num = 1000; // max value of any number in array
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] bucket = new int[Max_Num + 1];
        for (int i = 0; i < n; i++) {
            bucket[scan.nextInt()]++;
        }
        int beautifulPairs = 0;
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            if (bucket[num] > 0) {
                bucket[num]--;
                beautifulPairs++;
            }
        }
        scan.close();
        
        // Accounts for changing 1 element in B 
        if (beautifulPairs == n) {
            beautifulPairs--;
        } else {
            beautifulPairs++;
        }
        System.out.println(beautifulPairs);
    }
}
  