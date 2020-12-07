#include <bits/stdc++.h>

using namespace std;

vector<int> dynamicArray(int n, vector<vector<int>> queries) {
    vector<vector<int>>seqlist(n);  //Dynamic array allocation
    vector<int>ans; // vector array which will contain array
    int lastans=0; // Lastanwer given in question initialised with zero.
    int p=queries.size(),i=0; //size of queries for ease only
    while(i<p){  //traversing queries 
        if(queries[i][0]==1){ 
            // for type 1 query
            int temp=(queries[i][1]^lastans)%n; // variable to store index which we need to excess
            seqlist[temp].push_back(queries[i][2]); // performing type 1 query
        }else{
            // for type 2 query
            int temp=(queries[i][1]^lastans)%n; // variable to store index which we need to excess
            int q=seqlist[temp].size();  // variable to solve the type 2 query as given in question
            int b=queries[i][2]%q;
            lastans=seqlist[temp][b];
            ans.push_back(seqlist[temp][b]); // inserting outputs which we need to give 
        }
        i++;
    }
    return ans; // returning the vector
}

int main()
{
    int n ,q; // variables given in question
    cin>>n>>q; //reading input

    vector<vector<int>> queries(q); // 2D array to store queries

    for (int i = 0; i < q; i++) {
        queries[i].resize(3);

        for (int j = 0; j < 3; j++) {
            int a; // reading inputs of each query
            cin>>a;
            queries[i][j] = a;
        }
    }

    vector<int> result = dynamicArray(n, queries);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i]<<"\n"; //output of each testcase
    }

    return 0;
}

