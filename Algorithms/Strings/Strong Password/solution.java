import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static final String Special_Character = "!@#$%^&*()-+";
                           
    // minimumNumber function
    static int minimumNumber(int n, String password) {
        int addNum = 0;
        if (!password.chars().anyMatch(Character::isDigit)) {
            // for digits
            addNum++;
        }
        if (!password.chars().anyMatch(Character::isLowerCase)) {
            // for lowercase letters
            addNum++;
        }
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            // for uppercase letters
            addNum++;
        }
        if (!password.chars().anyMatch(ch -> Special_Character.indexOf((char) ch) >= 0)) {
            // for special characters
            addNum++;
        }
        addNum = Math.max(addNum, 6 - n);

        // Returning the minimum number of characters to make the password strong
        return addNum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    // main function
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
