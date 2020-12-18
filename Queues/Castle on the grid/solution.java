import java.io.*;
import java.util.*;

public class solution {
      /* Main idea behind solving the problem
        1. addd starting point to queue
        2. dequeue point and go as far as possible in clowise direction, top right bot left
        3. for every element in grid mark as visited
           if not visited yet, dist = current distance + 1
         4. repeat until end point is found
         */
    private static class BFS{
        int n;
        char[] grid;
        boolean[] visited;
        int[] dist;
        int start;
        int end;
        LinkedList<Integer> q;
        boolean found = false;
        
        public BFS(int n, char[] grid, int start, int end){
            this.n = n;
            this.grid = grid;
            this.start = start;
            this.end = end;
            visited = new boolean[n*n];
            dist = new int[n*n];
            
            q = new LinkedList<Integer>();
            this.start();
        }
        
        private int answer(){
            return dist[end];
        }
        
        
        private void visit(int next, int cur){
            if(!visited[next]){
                dist[next] = dist[cur] + 1;
                visited[next]= true;
                q.add(next);
            }
        }
        
        private int convert(int row, int col){
            return row*n+col;
        }
        
        
        private void start(){
             // to keep track of nodes and their distances from starting point
            q.add(start);
             //marking as visited
            visited[start] = true;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                int row = cur/n; int col = cur%n;
                int r= row; int c = col;
                int next =0;
                
                //up
                while(r>0){
                   next = this.convert(--r,c);
                   if (grid[next]=='X') break;
                   else {
                       visit(next, cur);
                       if (next==end) return;
                   }
                }
                
                //down
                r= row; c = col;
                while(r<n-1){
                   next = this.convert(++r,c);
                   if (grid[next]=='X') break;
                   else {
                       visit(next, cur);
                       if (next==end) return;
                   }
                }
                
                
                //left
                r= row; c = col;
                while(c>0){
                   next = this.convert(r,--c);
                   if (grid[next]=='X') break;
                   else {
                       visit(next, cur);
                       if (next==end) return;
                   }
                }
                
                //right
                r= row; c = col;
                while(c<n-1){
                   next = this.convert(r,++c);
                   if (grid[next]=='X') break;
                   else {
                       visit(next, cur);
                       if (next==end) return;
                   }
                }
                
            }

            
        }
     
        
        
    }
    
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int i =0;
        int count =n;
        char[] grid = new char[n*n];
        sc.nextLine();
        
        while(count>0){
            String input = sc.nextLine();
            for(int j=0;j<n;j++){
                grid[i*n+j] = input.charAt(j); 
            }
            i++;
            count--;
        }
        int start = sc.nextInt()*n+sc.nextInt();
        int end = sc.nextInt()*n+sc.nextInt();
        
        
        BFS bfs = new BFS(n, grid, start, end);
        System.out.println(bfs.answer());
        
        
      
        
        }
        
}