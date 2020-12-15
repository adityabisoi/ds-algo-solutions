import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static long two = 2;
 //to get powers of 2 for demial-binary conversion
	public static long getPowOf2(int i) {
		if (i == 0)
			return 1;
		else
    //left shift the bits of 2 to i-i position to take 2^i-1
			return (two << (i - 1));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);
		int t = sc.nextInt();
    //no. of test cases
		while (t-- > 0) 
    {
			long n = sc.nextLong();
			long answer = 0;
			for (int i = 0; i < 32; i++) 
      {
				
				if (((n >> i) & 1) == 0) 
        {
					answer = answer + getPowOf2(i);
				}
			}
			System.out.println(answer);
		}

	}
}
