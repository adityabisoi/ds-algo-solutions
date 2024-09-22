import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        while (T-- > 0) {
            String str = in.next();
            System.out.println(findRemovalIndex(str));
        }

        in.close();
    }

    static int findRemovalIndex(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                // Check both possible removals
                if (isPalindrome(str, left + 1, right)) {
                    return left;
                }
                if (isPalindrome(str, left, right - 1)) {
                    return right;
                }
                return -1; // Not a palindrome with one removal
            }
            left++;
            right--;
        }
        return -1; // Already a palindrome
    }

    static boolean isPalindrome(String str, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            if (str.charAt(beginIndex) != str.charAt(endIndex)) {
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }
}
