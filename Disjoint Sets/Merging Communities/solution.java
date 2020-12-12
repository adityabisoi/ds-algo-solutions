import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static final String QUERY_Q = "Q";
    public static final String QUERY_M = "M";
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt(); // Taking number of peopl e as input.
        int q = sc.nextInt(); // Taking number of queries as input.

        Integer  arr[] = new Integer[n];
        Integer counts[] = new Integer[n]; //Array to store size of community.
        Integer commID = 0;
        
        //For loop traversing across all the queries.
        for(int qloop=0; qloop<q; qloop++) {
            
            String query = sc.next(); //Taking the query as input.
            
            //Query of the form Q I
            if(query.equals(QUERY_Q)) {
                int person = sc.nextInt();
                Integer comm = arr[person-1]; //Stores community to which the person belongs to.
                int size = ((comm == null) ? 1:counts[comm]); //stores the size of community. If it is initial stage then size is 1.
                sb.append(size).append('\n');
            }
            
            //Query of the form M I J
            if(query.equals(QUERY_M)) {
                // merge communities
                
                int personA = sc.nextInt(); //Taking input first person
                int personB = sc.nextInt(); //Taking input second person
                
                if(personA != personB) {
                    
                    //Stores community of first and second person of query M I J.
                    Integer commA = arr[personA-1];
                    Integer commB = arr[personB-1];
                    
                    if(commA != null && commB != null) {
                        if(commA == commB) { //Already belong to the same community
                            // Hence no action is done.
                            ; 
                        } 
                        
                        else {
                            
                            // Merge communities
                            // Get the two communities of specified persons 
                            // Iterate over list of persons of smaller community.
                            // Set them to community (value) of larger community. 
                        
                            
                            if(counts[commA] > counts[commB]) {
                                int remain = counts[commB];
                                
                                for(int i=0; i<arr.length; i++) {
                                    if(arr[i]==commB) {
                                        arr[i]=commA;
                                        if(--remain <= 0) break;
                                    
                                     }
                                }
                                
                                counts[commA] += counts[commB];
                                counts[commB] = null;
                            }
                            else {
                                int remain = counts[commA];
                                for(int i=0; i<arr.length; i++) {
                                    if(arr[i]==commA) {
                                        arr[i]=commB;
                                        if(--remain <= 0) {
                                            break;
                                        }
                                    }
                                }
                                counts[commB] += counts[commA];
                                counts[commA] = null;
                            }
                        }
                        
                    } 
                    
                    else if(commA == null && commB == null) {
                        // Create a new community containing both personA and personB
                        arr[personA-1] = commID;
                        arr[personB-1] = commID;
                        counts[commID] = 2;//Since both persons belong to a new community and hence its size is 2.
                        commID++;
                    } 
                    
                    else {
                        //Only one person belongs to a new community.
                        //Increment community value of existing community. 
                        
                        if(commA != null) {
                            arr[personB-1] = commA;
                            counts[commA]++;
                        } 
                        else {
                            arr[personA-1] = commB;
                            counts[commB]++;
                        }
                    }
                }
            }//For loop over the queries end.
        }
        System.out.print(sb.toString()); 
        sc.close();
    }
}
