import java.util.Scanner;

/*
    In insertion sort we shift each element ahead until we meet element which is less than the key value;

    First loop visits all the elements of array starting from index 1
    Second loop shifts all the value which are greater than key until
    it meets a element which has less value than  key value

   */

public class solution {

    // Complete the runningTime function below.
    public static void runningTime(int[] arr) {
        int shifts=0; // no of shifts done will be stored in this variable
        int n=arr.length;
        //1st loop
        for(int i=1; i<n; i++){
            int j=i-1;
            int temp=arr[i]; //key value
            // 2nd loop
            while(j>=0&&arr[j]>temp){
                shifts++; //do 1 shift and increase the value of shift
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp; // assigning key value to the index which is greater than j beacuse arr[j] is less 
                           //than key beacuse of which we came out of loop
        }
        System.out.println(shifts); // now print the value of shift as asked in question
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int[] array = new int[s];
        for (int i = 0; i < s; i++) {
            array[i] = scan.nextInt(); 
        }
        runningTime(array);
    }
}
