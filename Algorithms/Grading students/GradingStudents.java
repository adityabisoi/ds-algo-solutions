import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), grade;
        for(int i = 0; i < n; i++){
            grade = in.nextInt();
            System.out.println(getRoundedGrade(grade));
        }
        in.close();
    }

    public static int getRoundedGrade(int grade) {
        if (grade >= 38) {
            int rem = grade % 5;
            if (rem > 2) {
                grade += (5 - rem);
            }
        }
        return grade;
    }
}
