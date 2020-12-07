/*
@Author : Harikrishnan6336
HackerRank question :- Array Manipulation 
https://www.hackerrank.com/challenges/crush/problem

Prerequisites: Arrays, Prefix Sum

Solution intuition: We add each value 'val' to the starting index and subtract val from the (end+1)th index, 
thus maintaining the array in such a way that the prefix sum of the i'th index will give the value of that index. 
*/


#include <bits/stdc++.h>
using namespace std;

int main()
{
    long int n,op;  
    cin>>n>>op;     // n - size of the array, op - number of operations.
    //Initialize all the values of the array as zero.
    long int a[n+1] = {0};
    // start and end indicies and value to be added.
    long int start,end,val; 
    for(unsigned long int i=0;i<op;i++)
    {   
        cin>>start>>end>>val;
            a[start]+=val; // add val to start index
            if(end+1 <= n)
              a[end+1]-=val;  // subtract val from end index
    }
    
    long int max=0,sum=0;
    // Sum the array elements and find the maximum sum.
    for(unsigned long int i=1;i<=n;i++)
    {
        sum+=a[i];
        
       if(max < sum)
         {max = sum;}
    }
    
    cout<<max;
    return 0;
}
