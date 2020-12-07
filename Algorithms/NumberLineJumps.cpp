//Problem Link:https://www.hackerrank.com/challenges/kangaroo/problem
//Code Contributed By Khushi Gupta

#include<bits/stdc++.h>
using namespace std;

int main()
{
    int x1,x2,v1,v2;

    cin>>x1>>v1>>x2>>v2;

    int x=x1-x2;
    int v=v2-v1;

    if(x==0)// If the two kangaroos are at same position
    {
        cout<<"YES\n";
    }
    else if(v==0)//If kangaroos are not at same position and metres covered per jump are same then they will never meet
    {
        cout<<"NO\n";
    }
    else if((x%v)==0&&(x/v)>0)//Passing condition
    {
        cout<<"YES\n";
    }
    else//Remaining conditions
    {
        cout<<"NO\n";
    }
}
