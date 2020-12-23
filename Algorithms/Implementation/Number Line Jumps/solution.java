// kangaroo 2 is always starting ahead of kangaroo 1
// so kangaroo 1 must be faster than kangaroo 2
// if they have to land at same spot after same number of jumps
// 
// now because kangaroo 1 must be faster
// if kangaroo 1 passes kangaroo 2 without meeting at same spot
// they langaroo 2 can never catch up to kangaroo 1
// so they will never meet in this case also

import java.io.*;   //importing io library to use BufferedReader and InputStreamReader

public class solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));  //preparing input stream
        String[] param;
        param = reader.readLine().split("\\s");   //taking space separated input into array
        int int_para[] = new int[4];
        for (int i=0;i<4;i++)
        {
            int_para[i] = Integer.parseInt(param[i]);   //converting string elements to integers
        }

        //assigning to respective variables
        int x1 = int_para[0];
        int v1 = int_para[1];
        int x2 = int_para[2];
        int v2 = int_para[3];
        
        if(v1 <= v2)    //if kangaroo 1 speed is slower than or eual to speed of kangaroo 2 then they will never meet
        {
            System.out.println("NO");
        }
        else
        {
            while(x1 <= x2)
            {
                if(x1 == x2)    //checking for same position
                {
                    System.out.println("YES");
                    break;
                }

                //jumps added
                x1 = x1 + v1;
                x2 = x2 + v2;
                
                if(x1 > x2)   //if kangaroo 1 is ahead of kangaroo 2, then they will never meet
                {
                    System.out.println("NO");
                }
            }
        }
    }
}