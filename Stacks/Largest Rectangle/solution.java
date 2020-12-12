import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] heights = new int[N + 1];
		for (int i = 0; i < N; i++) {     //run for loop
			heights[i] = in.nextInt();
		}
/*
Stack approach
Add into stack when the input value is greater than the top value in the stack
else, pop the stack till the stacks top value is less than or equal
and check the area and add that to stack
final step - empty the stack while calculating the area
*/

		long maxArea = 0;
		Stack<Integer> indices = new Stack<Integer>();
		for (int i = 0; i < heights.length; i++) {
			while (!indices.empty() && heights[i] <= heights[indices.peek()]) {
				int index = indices.pop();   // if condition holds true then delete one element and assign to index variable
				long area = (long) heights[index]
						* (i - (indices.empty() ? 0 : (indices.peek() + 1)));
				maxArea = Math.max(maxArea, area);
			}
			indices.push(i);
		}
		System.out.println(maxArea);

		in.close();
	}
}
