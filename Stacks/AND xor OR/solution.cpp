/*Firstly understand mathematically that the expession of Si 
is just a complicated version of a normal xor between M1 and M2
In this solution we maintain a stack, what it helps us to do is 
that we can always break the loop if the top element isn't minimum
This modification makes it significantly faster compared to naive approach
where it would have taken O(n^2) time*/

#include<bits/stdc++.h>
using namespace std;

int main()
{    
    vector <long long> v;
    stack <long long> s;
    long long temp,i,n;
    long long max_xor=0,min_xor;
    cin>>n;
    for(i=0;i<n;i++) //loop for taking input in vector 
    {
        cin>>temp;
        v.push_back(temp);
    }
    for(i=0;i<n;i++)
    {
        while(!s.empty()) //taking xor and comparing with max xor
        {                 //untill either stack is empty or the top element isn't M1 or M2
            min_xor=v[i]^s.top();
            if(min_xor>max_xor) //taking xor with the top element and ckecking with max
              max_xor=min_xor;
            if(v[i]<s.top()) //popping all the elements greater than v[i]  from the stack
              s.pop();       //so that the min element remains on top
            else  //if the element is smaller we have the 
              break;
        }
        s.push(v[i]);
    }
    cout<<max_xor<<endl;
}
