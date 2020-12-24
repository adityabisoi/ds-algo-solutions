#include<bits/stdc++.h>
using namespace std;

//Function to find the index
int saveThePrisoner(int n, int m, int s) {
    // The index of last prisoner who gets the last piece of candy is m + s - 1 .
    // But if this index becomes larger than the number of prisoners , then we have to start traversing from the beginning (since we are moving in a circle), hence it is required to find modulus of this sum.
    // Increment by 1 , since starting index is 1. 
    return (m+s-2)%n + 1;
    
}
int main(){
    int t;
    cin>>t; //Input the number of test cases
    while(t--){
        int n,m,s;
        cin>>n>>m>>s;
        cout<<saveThePrisoner(n,m,s)<<endl;
    }
    return 0;
}
