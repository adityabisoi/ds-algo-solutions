import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt(); // number of cities in Goodland
        int k = in.nextInt(); // plants' range constant
        
        // array of elements indicating suitability for building a plant
        int[] cities = new int[n];
        
        for(int i=0; i < n; i++){
            cities[i] = in.nextInt();
        }
        
        int index = 0;
        int range = 0;
        int changes = 0;
        
        while(index < n){
            
            if(index < range){
                // city is already in range                
            }
            else{
                // find a tower to switch on
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
                
                // no way to handle current city
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