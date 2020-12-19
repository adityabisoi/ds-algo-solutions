import java.util.Scanner;

public class solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        // input return date
        String[] return_date = sc.nextLine().split(" ");
        int rd = Integer.parseInt(return_date[0]);      // return day
        int rm = Integer.parseInt(return_date[1]);      // return month
        int ry = Integer.parseInt(return_date[2]);      // return year
        
        // input due date
        String[] due_date = sc.nextLine().split(" ");
        int dd = Integer.parseInt(due_date[0]);      // due day
        int dm = Integer.parseInt(due_date[1]);      // due month
        int dy = Integer.parseInt(due_date[2]);      // due year
        
        int fine = 0;
        
        if (ry > dy)
            fine = 10000;
        else if(ry == dy)
        {
            if(rm > dm)
                fine = 500 * (rm - dm);
            else if(rm == dm)
            {
                if(rd > dd)
                    fine = 15 * (rd - dd);
            }
        }
        
        System.out.println(fine);
        sc.close();
    }
}