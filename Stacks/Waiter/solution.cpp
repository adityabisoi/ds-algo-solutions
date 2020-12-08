#include<bits/stdc++.h>
using namespace std;
const int SIZE=(int)1e4;
vector<int>prime,vis;
//Sieve of eratosthenes
void sieve()
{
    for(int i=2;i*i<=SIZE;i++){
        if(vis[i]==0){
            for(int j=i*i;j<=SIZE;j+=i){
                if(vis[j]==0)
                    vis[j]=i;
                //The value of vis[j] will be its smallest prime factor
            }
        }
    }
    for(int i=2;i<=SIZE;i++){
        if(!vis[i]){
            prime.push_back(i);
            //Vector of prime numbers
            vis[i]=i;
        }
    }
}
int main(){
    int n,q,last_prime;
    //last_prime represents the largest prime number that will be reached in Q iterations
    cin>>n>>q;
    vis.assign(SIZE+1,0);
    vector<int>v(n),temp;
    sieve();
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
    map<int,vector<int>>mp;
    //It will map the vector of the numbers divisible by the prime number to the prime number
    map<int,int>state;
    //It maps the state to the prime number
    //The numbers can be in normal or reverse order based upon the index of the prime number
    int o=0;
    //This variable will hold the ordering of the numbers
    //o=1 : normal order
    //o=0 : reverse order
    for(auto p:prime){
        if(q--){
            last_prime=p;
            state[p]=o;
            //Mapping the ordering to the prime number
            o^=1;
        }
        else{
            o^=1;
            //The order of the remaining numbers
            break;
        }
    }
    for(auto x:v){
        if(vis[x]<=last_prime){
            mp[vis[x]].push_back(x);
            //Mapping each number to its smallest prime factor
        }
        else{
            temp.push_back(x);
            //temp is the vector of the remaining numbers (Aq)
        }
    }
    for(auto p:prime){
        if(p<=last_prime){
            if(state[p]==1){
                reverse(mp[p].begin(), mp[p].end());
                //Correcting the vector's order
            }
            for(auto x:mp[p]){
                cout<<x<<endl;
            }
            //Printing the numbers whose smallest divisor is p
        }
        else{
            if(o==1){
                reverse(temp.begin(), temp.end());
                //Correcting the vector's order
            }
            for(auto x:temp){
                cout<<x<<endl;
            }
            //Printing the numbers that could not be divided by any prime factors in Q iterations
            break;
        }
    }
}
