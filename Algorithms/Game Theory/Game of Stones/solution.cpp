//Game of stones
//Link-https://www.hackerrank.com/challenges/game-of-stones-1/problem
//Level- Easy

/*
    All game theory problems have pattern we just need to observe them.
    In this question
        - Answer when n is 1 Second will win every time as valid moves are 2 or 3 or 5
        - Answer when n is 2 or 3 or 4 or 5 First will win every time this can be seen by solving
        - On the basis of above conclusion this can be deduce that 
            - when n is divisible by 7 Second will win
            - when n%7 is 1 Second will win
            - when n%7 greater than one First will win no matter what
*/

#include <bits/stdc++.h>

using namespace std;


int main()
{
    int t;
    cin >> t;
    
    for (int t_itr = 0; t_itr < t; t_itr++) {
        int n;
        cin >> n;
        if(n%7>1){
            // If n%7 is greater than one First will win
            cout<<"First\n";
        }else{
            // else Second will win
            cout<<"Second\n";
        }
    }


    return 0;
}
