/*
    If n is divisible by 3 we will print 5 n times
    if n when divided by 3 gives remainder 1 we need to subtract 5 twice 
        Ex - 16%3 =1 now n-10=6 is divisible 3 
    and if n when divided by 3 gives 2 remainder we need to subtract 5 one time
        Ex - 17%5=2 now n-5=12 is divisible by 3
*/

import java.util.*;

class solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            StringBuffer sb = new StringBuffer();
            //when n is divisble by 3
            if (n%3==0) {
                System.out.println(append(n,"5"));
            } else if (n%3==1) { //when n%3 leaves remainder 1
                if (n<10) {
                    System.out.println("-1");  // when n-10 is less then 0 
                } else {
                    System.out.println(append(n-10,"5") + (append(10,"3")));
                }
            } else if (n%3==2) { //when n%3 leaves 2 remainder
                if (n<5) {
                    System.out.println("-1");   //n-5 is less than 0
                } else {
                    System.out.println(append(n-5,"5") +(append(5,"3")));
                }
            }

        }
    }
    private static String append(int numberOfTimes , String value){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numberOfTimes; i++) {
            sb.append(value);           
        }
        return sb.toString();
    }
}