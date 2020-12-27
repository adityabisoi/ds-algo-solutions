//Game of stones
//Link-https://www.hackerrank.com/challenges/tower-breakers-1/problem
//Level- Easy

/*
    All game theory problems have pattern we just need to observe them.
    
    In this question
       - when m==1 there is no positive divisor of  which is smaller than , so there is no possible move to be made when . Because of this, player  will always win in this scenario.
       - When  is n is even imagine that the towers are separated into two groups having an equal number of  towers in each group. 
         There same no of towers on each side whenever player 1 decreases height of tower in one move, 
         player 2 can simply copy player 1's last move and apply it to a tower from the second group.
         In this way, player  will always have move to play so player 2 will always win.
       - When  is odd, player 1 choses a tower and breaks it down to a height of 1. This results in  remaining breakable towers, which is an even number. 
         Because we know that the first player to make a move when there are an even number of towers always loses (see above, when n is even), we can deduce that player 1 will always win.
*/

#include<bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m;
        cin>>n>>m;
        if(n%2==1 && m!=1)
            cout<<1<<"\n";
        else
            cout<<2<<"\n";
    }
}