#include<bits/stdc++.h>

using namespace std;

// Dynamic array function
vector<int> dynamicArray(int n,vector<vector<int>>queries)
{
    vector<vector<int>>seqlist(n);  //sequence list which has all the sequences
    int i=0,p=queries.size();
    int lastans=0; // as given in question initialise last answer=0;
    vector<int>ans; //vector which will contain output from 2nd query
    while(i<p){
        //for type 1 query
        if(queries[i][0]==1){
            int temp=(queries[i][1]^lastans)%n;
            seqlist[temp].push_back(queries[i][2]);
        }else{
            //for type 2 query
            int temp=(queries[i][1]^lastans)%n;
            int q=seqlist[temp].size();
            int b=queries[i][2]%q;
            lastans=seqlist[temp][b];
            ans.push_back(seqlist[temp][b]);
        }
        i++;
    }
    return ans;
}

// Driver function
int main(){
    int n,q;
    cin>>n>>q;
    vector<vector<int>>queries(q);
    for(int i=0; i<q; i++){
        int t,x,y;
        cin>>t>>x>>y;
        queries[i].resize(3);
        queries[i][0]=t;
        queries[i][1]=x;
        queries[i][2]=y;
    }
    vector<int>result=dynamicArray(n,queries);
    int p=result.size();
    for(int i=0; i<p; i++){
        cout<<result[i]<<" ";
    }
}