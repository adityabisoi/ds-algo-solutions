import java.util.Scanner;

public class _2dArrayDS {
    private static final int MAX = 6; // size of matrix
    private static final int OFFSET = 2; // hourglass width
    private static int mat[][] = new int[MAX][MAX];
    private static int maxHourglass = -63; // initialize to lowest possible sum (-9 x 7)

    /** Given a starting index for an hourglass, sets maxHourglass
     *   @param i row
     *   @param j column
     **/
    private static void hourglass(int i, int j){
        int temp = 0; // current hourglass sum
        // sum top 3 and bottom 3 elements
        for(int k = j; k <= j + OFFSET; k++){
            temp += mat[i][k];
            temp += mat[i + OFFSET][k];
        }
        // sum middle element
        temp += mat[i + 1][j + 1];

        if(maxHourglass < temp){
            maxHourglass = temp;
        }
    }

    public static void main(String[] args) {
        // read inputs
        Scanner scan = new Scanner(System.in);
        for(int i=0; i < MAX; i++){
            for(int j=0; j < MAX; j++){
                mat[i][j] = scan.nextInt();
            }
        }
        scan.close();

        // find maximum hourglass
        for(int i=0; i < MAX - OFFSET; i++){
            for(int j=0; j < MAX - OFFSET; j++){
                hourglass(i, j);
            }
        }

        // print maximum hourglass
        System.out.println(maxHourglass);
    }
}
