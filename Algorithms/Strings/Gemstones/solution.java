
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    What we are doing is following these three steps
        1. Choosing 1 character from a-z now traversing through all the strings given
        2. If we found that choosen character in the given string we come out of that loop and increase the count by one
        3. now suppose that character is not present in that string we have traversed what we will do is check 
            a. If we have traversed whole lengthof the string if yes then we will move to next character and won't increase count by one

*/

public class solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int count =0;
        //loop for traversing all characters form a-z
        for(int i=97; i<124; i++){
            char a=(char)i;
            int j;
            // now traversing through all the given string 
            for( j=0; j<arr.length; j++){
                String s=arr[j];
                int p=0;
                while(p<s.length()){
                    if(s.charAt(p)==a){ // if we find choosen character in the string we come out of that loop immediately
                         break;
                     }
                    p++;
                }
                //we check if we are at end of string  if yes this character is not gemstone 
                //and we won't traverse through remaining string and come out of this loop
                //if we are not at end we will keep traversing through string if any string is left
                if(p==s.length()){
                     break;
                }
            }
            //now if we have traversed through all the string given
            //value of j will be equal to size of arr and we will increase the count by one if all previous conditions are fullfilled
            //if we have not traversed through loop we on't increase the scount
            if(j==arr.length){
                count++;
            }
        }
        return count; //return the count

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
