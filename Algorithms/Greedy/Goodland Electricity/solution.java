import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[] cities = new int[n];
        
        for(int i=0; i < n; i++){
            cities[i] = in.nextInt();
        }
        
        int index = 0;
        int range = 0;
        int changes = 0;
        
        while(index < n){
            
            if(index < range){
                // nothing               
            }
            else{
                int towerEnd = index+k;
                int towerStart = index-k+1;
                if(towerStart < 0){
                    towerStart = 0;
                }
                int tower = -1;
                
                for(int j=towerStart; j<towerEnd && j<n; j++){
                    if(cities[j] == 1){
                        tower = j;
                    }
                }
                
                if(tower == -1){
                    System.out.println(-1);
                    return;
                }
                else{
                    changes++;
                    index = tower;
                    range = index + k;
                }
            }
            
            index++;
        }
        
        System.out.println(changes);
    }
}