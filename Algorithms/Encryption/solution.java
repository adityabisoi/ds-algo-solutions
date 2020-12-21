import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Double a = Math.sqrt(s.length()); 
		int h = (int) Math.floor(a);
		int w = (int) Math.ceil(a);
		int count = 0;
		char ar[] = s.toCharArray();
			
		for(int i=0;i<w;i++){
			int j = i;
			while(j<s.length()){
				System.out.print(ar[j]);
				j += w;
				count++;
			}
			System.out.print(" ");
		}
	}

}
