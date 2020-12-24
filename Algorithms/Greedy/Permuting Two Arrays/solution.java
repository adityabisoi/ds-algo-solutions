
import java.util.*;
import java.util.Collections;

public class solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt(); // number of test cases
        while(test!=0)
        {
            int n=sc.nextInt(); // length of arrays
            int k=sc.nextInt(); // value of k
            Integer[] a1=new Integer[n];
            Integer[] a2=new Integer[n];

            // 1st ARRAY
            for(int i=0;i<n;++i)
            {
                a1[i]=sc.nextInt();
            }
            // 2nd ARRAY
            for(int i=0;i<n;++i)
            {
                a2[i]=sc.nextInt();
            }

            Arrays.sort(a1); //sorting the 1st array in reverse order
            Arrays.sort(a2, Collections.reverseOrder());  //sorting the 2nd array in reverse order
            
            int flag=0;

            // if two indexes summ in both array is greater than k we will print NO else for any condition we will prent YES
            for(int i=0;i<n;++i)
            {
                //checking if two indexes sum has the value greater than k or not
                if(a1[i]+a2[i]<k)
                {
                    flag=1;
                    break;
                }
            }
            // if flag did not change we will print YES
            if(flag==0)
            {
                System.out.println("YES");
            }
            else if(flag==1) // if flag is 1 means two indexes has sum greater than k
            {
                System.out.println("NO");
            }
            test--;
        }
    }
}