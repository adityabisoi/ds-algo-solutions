import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<String> stack = new Stack<String>();
        String s = "";
        
        for (int x = 0; x < q; x++) {
            int ope = sc.nextInt();
            switch (ope) {
                case 1: //append
                    stack.push(s);
                    String append = sc.next();
                    s += append;
                    break;
                case 2: //erase last x characters
                    stack.push(s);
                    int character = sc.nextInt();
                    s = s.substring(0, s.length() - character);
                    break;
                case 3: //print
                    int index = sc.nextInt();
                    System.out.println(s.charAt(index - 1));
                    break;
                case 4: //undo
                    s = stack.pop();
                    break;
                default:
                    break;
            }
        }
    }
}



/*
You can also do this problem by using below code : 
 import java.util.Scanner;
 import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder S = new StringBuilder();
		Stack<Operation> operations = new Stack<Operation>();
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				String W = sc.next();
				S.append(W);

				operations.push(new Operation(type, W.length()));
			} else if (type == 2) {
				int k = sc.nextInt();
				String last = S.substring(S.length() - k);
				S.delete(S.length() - k, S.length());

				operations.push(new Operation(type, last));
			} else if (type == 3) {
				int k = sc.nextInt();
				System.out.println(S.charAt(k - 1));
			} else {
				Operation operation = operations.pop();

				if (operation.type == 1) {
					S.delete(S.length() - (int) operation.argument, S.length());
				} else {
					S.append(operation.argument);
				}
			}
		}

		sc.close();
	}
}

class Operation {
	int type;
	Object argument;

	Operation(int type, Object argument) {
		this.type = type;
		this.argument = argument;
	}
}
*/