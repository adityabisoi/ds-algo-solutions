/*
    Misère Nim is exactly like the standard Nim game, except for one critical difference.
     If the size of every pile is , then we need to treat it as a special case where we count the number of piles. 
     If the count is even, then the first player will win; if the count is odd, then the first player will lose.


    If the size of every pile is not , then you can use XOR sum to determine who will win the game.
     If the XOR sum is zero the first player picks the last stone from the last pile hence looses, else the first player wins.
*/
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;



int main() {
    int t;cin>>t;
      
    while(t--){
        int n;
        cin>>n;
        int m=n;
        long ans=0;
        int c=0;
        while(n--){long s;
            cin>>s;
                          
            ans^=s;
            if(s==1) c++;
        }
        if((c!=m&&ans==0)||(c==m&&c%2!=0)) cout<<"Second"<<endl;
        else cout<<"First"<<endl;
    }
    
    return 0;
}