import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), grade;
        
        // For each grade, get rounded grade and print it on a new line
        for(int i = 0; i < n; i++) {
            grade = in.nextInt();
            System.out.println(getRoundedGrade(grade));
        }
        in.close();
    }

    
    public static int getRoundedGrade(int grade) {
        // As long as grade >= 38, using grade mod 5 >= 3 allows us to determine when we need to round a grade.
        if (grade >= 38) {
            // rem is the solution of grade mod 5.
            int rem = grade % 5;
            // if rem > 2, i.e. grade mod 5 >= 3, we need to round up.
            if (rem > 2) {
                grade += (5 - rem);
            }
        }
        return grade;
    }
}
