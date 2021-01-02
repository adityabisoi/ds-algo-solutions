/*
    This is a standard Nim game where you need to find the exclusive OR (XOR) of all stone piles to
     determine the winning and losing positions.
      To understand how it works, we recommend you to read 
      - https://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/?ref=rp

    The quickest solution is to XOR all values of array arr together. 
    If the value is 1, player 1 will win. Otherwise, it will be player 2.
*/
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;  //for number of testcases
    cin >> t;
    while(t--)
    {
       int n; //to store number of piles of stone
       cin >> n;
       int res=0; //to store the xor sum
       int a;
       for (int i=0;i<n;i++)
       {
          cin >> a;
          res^=a;
       }
       if (res) cout << "First";
       else cout << "Second";
       cout << endl;
    }
}