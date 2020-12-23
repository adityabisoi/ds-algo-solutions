import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution 
{
         static long marcsCakewalk(int[] calorie) 
       {
        int temp,i,j,n;
        n=calorie.length;
        
        //SORTING IN DESCENDING ORDER OF CALORIE FOR THE MINIMUM MILES WALK REQUIRED USING BUBBLE SORT TECHNIQUE
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<n-i-1;j++)
            {
                if(calorie[j]<calorie[j+1])
                {
                    temp=calorie[j];
                    calorie[j]=calorie[j+1];
                    calorie[j+1]=temp;
                }
            }
        }
        
       //STORING THE TOTAL MILES REQUIRED IN RESULT
       
       long result=0;
       for(i=0;i<n;i++)
       {
           result=result+(long)(Math.pow(2,i))*calorie[i];
       }
       
    //RETURNING THE TOTAL MILES IN THE MAIN FUNCTION
    
    return(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++)
        {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
