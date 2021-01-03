/*
    During each move, a player chooses one prime number and removes it (as well as its multiples) from the set. 
    Because a player cannot move unless there is at least one prime number in the set and a single prime number is removed during each turn,
     we simply need to count the number of primes in the inclusive range . 
     If the number of primes is odd, Alice will remove the last prime number and win the game;
      otherwise, this number is even and Bob will choose the last prime number, winning the game.

    You can get a 50% score if you generate prime numbers using a naive method. 
    For a full score, you should use a Sieve of Eratosthenes algorithm.
*/
#include <bits/stdc++.h>
using namespace std;

vector<bool> vec(100001);
bool peven;

void precompute(){
    for(int a=3;a<=100000;a++){
        bool div=false;
        for(int b=2;b<=sqrt(a);b++){
            if(a%b==0) {div=true; break;}
        }
        if(div) vec[a]=peven;
        else {peven=!peven; vec[a]=peven;}
    }
}

int main() {
    vec[0]=vec[1]=true;
    vec[2]=false; 
    peven=false;
    precompute();
    int t;
    cin>>t;
    while(t--){
        int k;
        cin>>k;
        if(vec[k]) cout<<"Bob"<<endl;
        else cout<<"Alice"<<endl;
    }
    return 0;
}