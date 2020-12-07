#include<bits/stdc++.h>
using namespace std;
const int SIZE=(int)1e4;
vector<int>prime,vis;
void sieve()
{
    for(int i=2;i*i<=SIZE;i++){
        if(vis[i]==0){
            for(int j=i*i;j<=SIZE;j+=i){
                if(vis[j]==0)
                    vis[j]=i;
            }
        }
    }
    for(int i=2;i<=SIZE;i++){
        if(!vis[i]){
            prime.push_back(i);
            vis[i]=i;
        }
    }
}
int main(){
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
    int n,q,last_prime=0;
    cin>>n>>q;
    vis.assign(SIZE+1,0);
    vector<int>v(n),temp;
    sieve();
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
    map<int,vector<int>>mp;
    map<int,int>mp1;
    int o=0;
    for(auto p:prime){
        if(q--){
            last_prime=p;
            mp1[p]=o;
            o^=1;
        }
        else{
            o^=1;
            break;
        }
    }
    for(auto x:v){
        if(vis[x]<=last_prime){
            mp[vis[x]].push_back(x);
        }
        else{
            temp.push_back(x);
        }
    }
    for(auto p:prime){
        if(p<=last_prime){
            if(mp1[p]==1){
                reverse(mp[p].begin(), mp[p].end());
            }
            for(auto x:mp[p]){
                cout<<x<<endl;
            }
        }
        else{
            if(o==1){
                reverse(temp.begin(), temp.end());
            }
            for(auto x:temp){
                cout<<x<<endl;
            }
            break;
        }
    }
}