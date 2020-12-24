/*
    /*
    What is asked convert the given string to specific string and increase the value by three
    Note - Uppercase letters can be any where in string so we need to keep track of that also

    1st if condition
    checks all uppercase letters and convert them to lowercase

    2nd if condition
    now incrementing all alphabets by three
*/



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {
	public static void main(String[] args) {
		int num=0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int k = in.nextInt()%26;
		StringBuffer sb = new StringBuffer(s);
		for(int i=0;i<n;i++){
			num=0;
			char ch;
			ch = s.charAt(i);
			if((int)ch >= 65 && (int)ch <= 90)
			{
				num = (int)ch + k;
				if(num>90){
					num=64+num-90;
            	}
				
                sb.setCharAt(i, (char)num);
			}
			if((int)ch >= 97 && (int)ch <= 122)
			{
				num = (int)ch + k;
				if(num>122){
					num=96+num-122;
				}
				
				sb.setCharAt(i, (char)num);
			}
		}
		
		System.out.println(sb);
        in.close();
		
    }
}