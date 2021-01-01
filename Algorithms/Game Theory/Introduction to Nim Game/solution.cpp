/*
    
*/
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t; cin >> t;
    while(t--)
    {
       int n, tmp; cin >> n;
       int res=0;
       for (int i=0;i<n;i++)
       {
          cin >> tmp;
          res^=tmp;
       }
       if (res) cout << "First";
       else cout << "Second";
       cout << endl;
    }
}