//Game of stones
//Link-https://www.hackerrank.com/challenges/a-chessboard-game-1/problem
//Level- Easy

/*
    All game theory problems have pattern we just need to observe them.
    In this game we need to identify the winning and losing positions. 
        - Initially mark the cells from which you can't move to any other cells as "losing positions".
        - Suppose you are at a cell now mark the cells you can reach by making valid moves
        - There are two possibilities if you can move to a cell which makes another player to a lossing state
        - If YES, then you can force your opponent into a losing state and win the game.
        - If NO, then you are in a losing state and won't be able to win the game
*/

#include<bits/stdc++.h>

using namespace std;

int main()
{
    int t,x,y;
    cin>>t;
    while(t--)
    {
        cin>>x>>y;
        if((x%4==0) || (x%4==3) || (y%4==0) || (y%4==3))
            printf("First\n");
        else
            printf("Second\n");
            
    }
    return 0;
}