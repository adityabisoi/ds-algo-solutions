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