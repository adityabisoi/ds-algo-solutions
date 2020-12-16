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
  