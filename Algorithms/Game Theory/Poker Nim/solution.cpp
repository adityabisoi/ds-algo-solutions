/*
    This problem is identical to standard nim game. 
    If the current player is in winning position and the opponent adds some chips, 
    the current player can remove those chips in his move and remain in winning position. 
    As the current player can mirror his opponent's "add" move all the time, that move has no value.
    Now you can find xor sum like standard nim game and determine who will win the game.
*/

#include <bits/stdc++.h>
using namespace std;
int main()
{
    int q;
    cin>>q;
    while(q--)
    {
        int n,k;
        cin>>n>>k;
        int ans=0;
        int x;
        for(int i=0;i<n;i++)
        {
            cin>>x; //input
            ans^=x;
        }
        if(ans!=0)
            cout<<"First\n";
        else
            cout<<"Second\n";
    }
}