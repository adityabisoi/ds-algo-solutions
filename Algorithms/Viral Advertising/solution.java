import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //The initial people is 5 so 5 is assigned to variable p
    
    //variable sum is for the cumulative people who liked the advertisement
    
    static int viralAdvertising(int n) {
        int i,p=5,sum=0;
        
        //n is the number of days this continues from the launch day 1
        
        for(i=1;i<=n;i++)
        {
            //number of people liking the advt is floor( initial people/2)
            
            p=p/2;
            
            sum=sum+(p);
            
            //each person shares the advt with their 3 friends
            
            p=p*3;
        }
        return(sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        //calling the function viralAdvertising and passing no. of days 
        
        int result = viralAdvertising(n);
        
        //result stores the total number of people who liked the advt.
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
