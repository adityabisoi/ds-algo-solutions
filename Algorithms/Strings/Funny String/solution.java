import java.util.*;

/*
    We wil traverse thorough given char array from begigining of array and store abs(s[i]-s[i-1]) for each valid i in arr
    now we will traverse the same string from end i.e. s.length-1 and store abs(s[i]-s[i-1]) for each valid i in rarr
    
    now we compare each particular value of arr & rarr if there is mismatch we will print "Not Funny"
    on the other hand we reach the end of both array means their all values match
    Hence, we will return "Funny"
*/

public class solution {

    private static String isFunny(char[] s){
        int arr[]; //stores abs(s[i]-s[i-1]) for i=1 to i=s.length-1
        int rarr[]; //stores abs(s[i]-s[i-1]) for i=s.length-1 to i=1
        arr=new int[s.length];
        rarr=new int[s.length];
        for(int i = 1,j=0 ; i < s.length; i++,j++){
            arr[j]=Math.abs(s[i]-s[i-1]);
        }
        int j=0;
        for(int i = s.length-1 ; i >0; i--,j++){
            rarr[j]=Math.abs(s[i]-s[i-1]);
        }
        for(int i=0;i<j; i++){
            //if any value of both these array doesn't matches we return "Not Funny"
            if(arr[i]!=rarr[i]){
                return "Not Funny";
            }
        }
        //If we have reached here means all the values of both the arrays have matched and means they are Funny
        //Hence we will return "Funny"
        return "Funny";
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(
                isFunny( in.next().toCharArray() )
            );
        }
        in.close();
    }
}
