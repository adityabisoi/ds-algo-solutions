import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // function to check if brackets match or not
    static boolean Match(char ch1, char ch2) {
        if(ch1=='{' && ch2=='}'){ // { }
            return true;
        }else if(ch1=='[' && ch2==']'){ // [ ]
            return true;
        }else if(ch1=='(' && ch2==')'){ // ( )
            return true;
        }else{
            return false;
        }
    }
    
    // function to check if it is balanced
    static String isBalanced(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0; i<s.length(); i++){ // traversing string
            char ch= s.charAt(i); // character of string at index i
            if(ch=='{' || ch=='[' || ch=='('){
                // encountering opening bracket
                st.push(ch);
            }else 
                // iencountering non-opening bracket, first check if stack is empty
                if(st.empty()){
                    return "NO";
                }else {
                    // when stack is not empty
                    if(Match(st.peek(), ch)){
                        st.pop();
                    }else{
                        return "NO";
                }
            }
        }
        // if stack is empty at the end then only it is balanced
        if(st.empty()){
            return "YES";            
        }else{
            return "NO";
        }
       
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt(); // number of Test cases
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine(); // string to be checked

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
