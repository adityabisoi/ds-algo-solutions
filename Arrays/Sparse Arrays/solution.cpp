/*
@Author : Harikrishnan6336
HackerRank question :- Sparse Arrays
https://www.hackerrank.com/challenges/sparse-arrays/problem

Prerequisite: Character Arrays

Solution intuition: A simple Linear search is the most efficient solution.

*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    string strs[1001];
    int q,m;
    cin>>m;       // m - number of strings
    for(unsigned long int i=0;i<m;i++)
    {
        cin>>strs[i];   // Input the strings
    }   
    cin>>q;      // q - number of queries

    for(unsigned long int i=0;i<q;i++)
    {   
        int cnt=0;      //count of the occurence of query string 's' in strs
        string s;
        cin>>s;
        for(unsigned long int j=0;j<m;j++)
        {
            if(s == strs[j])
                {   
                    cnt++;  
                }
        }
        cout<<cnt<<"\n";
    }
    return 0;
}
