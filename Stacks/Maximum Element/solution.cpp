/*
The main idea behind this solution is to push not just the
number but also the maximum element of the stack.
We compare the previous maximum element with the newly 
added element in stack and update it if the new element 
is larger 
*/
#include <bits/stdc++.h>
using namespace std;

int main()
{
    stack<pair<int,int>> ele;
    int n;
    cin>>n;
    while(n--)
    {
        int t, v;
        pair<int, int> p1;
        cin>>t;
        if(t == 1)
        {
            cin>>v;
            if(ele.size() == 0)
            {
                ele.push(make_pair(v, v));
            }
            else
            {
                int i = ele.top().second;
                i = max(v, i);
                ele.push(make_pair(v, i));
            }
        }
        else if(t == 2)
        {
            ele.pop();
        }
        else
        {
            p1 = ele.top();
            cout<<p1.second<<endl;
        }
    }
    return 0;
}