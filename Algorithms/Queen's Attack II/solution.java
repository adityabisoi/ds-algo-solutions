import java.util.Scanner;
import java.lang.Math;

public class solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, k, rq, cq;
        String[] input1 = sc.nextLine().split(" ");   // input n and k
        n = Integer.parseInt(input1[0]);
        k = Integer.parseInt(input1[1]);
        String[] input2 = sc.nextLine().split(" ");   // input rq and cq
        rq = Integer.parseInt(input2[0]);
        cq = Integer.parseInt(input2[1]);
        int obstacles[][] = new int[k][2];
        
        for (int i = 0; i < k;i++)    // input obstacle coordinates
        {
            String[] input3 = sc.nextLine().split(" ");
            int r = Integer.parseInt(input3[0]);
            int c = Integer.parseInt(input3[1]);
            obstacles[i][0] = r;
            obstacles[i][1] = c;
        }
        
        int attack = queensAttack(n, k, rq, cq, obstacles);
        System.out.println(attack);
        sc.close();
    }
    
    public static int queensAttack(int n, int k, int rq, int cq, int obs[][])
    {
        int u = n - rq;               // up
        int d = rq - 1;               // down
        int r = n - cq;               // right
        int l = cq - 1;               // left
        
        // taking minimum because cannot go out of board
        int ru = Math.min(u, r);      // right up
        int rd = Math.min(d, r);      // right down
        int lu = Math.min(u, l);      // left up
        int ld = Math.min(d, l);      // left down
        
        // finding closest in all directions
        for(int i = 0; i < k; i++)
        {
            if (obs[i][1] == cq)      // same column
            {
                if (obs[i][0] < rq)
                    d = Math.min(d, rq-1-obs[i][0]);
                else
                    u = Math.min(u, obs[i][0]-rq-1);
            }
            else if (obs[i][0] == rq)  // same row
            {
                if (obs[i][1] < cq)
                    l = Math.min(l, cq-1-obs[i][1]);
                else
                    r = Math.min(r, obs[i][1]-cq-1);
            }
            else if (Math.abs(obs[i][0]-rq) == Math.abs(obs[i][1]-cq))    // diagonals
            {
                if (obs[i][1]>cq)
                {
                    if (obs[i][0]>rq)
                        ru = Math.min(ru, obs[i][1]-cq-1);
                    else
                        rd = Math.min(rd, obs[i][1]-cq-1);
                }
                
                else
                {
                    if (obs[i][0]>rq)
                        lu = Math.min(lu, cq-1-obs[i][1]);
                    else
                        ld = Math.min(ld, cq-1-obs[i][1]);
                }
            }
            
        }
        return (u + d + r + l + ru + rd + lu + ld);
    }
}