
/*
    This is a variation on the standard Nim game.
     If a coin is located at the  square, it can go to squares at index  to . 
     So there are  possibilities for every coin in each square. 
     So, you can think of it just as you would think of a pile of  stones. 
     Moving a coin to the left is just like taking a stone from a stone pile.


    After you reduce the game to standard Nim, you can find the XOR sum to solve the game. 
    Notice that square  has  stones of size . 
    So we can just take one instance of size  pile if  is odd, as XOR sum of even number of identical elements is zero.
     So, no matter how large the value of  is, you can easily find the XOR sum by checking if  is even or odd.

*/


#include<bits/stdc++.h>

using namespace std;

int main(){
    long t;
    cin>>t;
    while(t--){
        int n; //number of square
        cin>>n;
        int r=0; //for storing the xor sum
        for(int i=0; i<n; i++){
            int a;
            cin>>a; // input number of coins on each square
            if(a%2==1){
                r=r^i;
            }
        }

        
        cout<<(r!=0?"First":"Second"); //output
        cout<<'\n';
    }
}
