import java.util.Scanner;
import java.util.Stack;
 
public class StackMaxElement {
 
    public static void main(String arg[]) {
 
        // stack contains all the data
        Stack<Integer> stack = new Stack<>();
        // maxStack contains all the distinct max values
        Stack<Integer> maxStack = new Stack<>();
 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of queries
        for(int i=0;i<n;i++) {
            int input = sc.nextInt(); // type of query
            switch (input){
                case 1:
                    // Push the element x into the stack
                    int x = sc.nextInt();
                    stack.push(x);
                    if(maxStack.isEmpty() || x >= maxStack.peek()) {
                        maxStack.push(x);
                    }
                    break;
 
                case 2:
                    // Delete the element present at the top of the stack
                    int popVl = stack.pop();
                    if(popVl == maxStack.peek()) {
                        maxStack.pop();
                    }
                    break;
 
                case 3:
                    // Print the maximum element in the stack
                    System.out.println(maxStack.peek());
                    break;
 
                default: break;
            }
        }
    }
}