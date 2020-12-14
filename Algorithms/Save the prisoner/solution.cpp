#include<bits/stdc++.h>
int saveThePrisoner(int n, int m, int s) {
    
    if ((s+m-1)%n)
        return ((s+m-1)%n);
    else
        return n;
    
}
int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m,s;
        cin>>n>>m>>s;
        cout<<saveThePrisoner(n,m,s)<<endl;
    }
    return 0;
}
