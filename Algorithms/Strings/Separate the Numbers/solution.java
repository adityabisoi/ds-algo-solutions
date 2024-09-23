import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {

    static void separateNumbers(String s) {
        int f=0;
        long w=0l;
        for(int x=0;x<s.length()/2;x++)
        {
            String a=s.substring(0,x+1);
            long q=Long.parseLong(a);
            w=q;
            a=""+q;
            while(a.length()<s.length())
            {
                q++;
                a=a+q;
            }
            if(a.equals(s))
            {
                System.out.println("YES "+w);
                f++;
                break;
            }
        }
        if(f==0)
        {
            System.out.println("NO");
        }
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            separateNumbers(s);
        }
        in.close();
    }
}