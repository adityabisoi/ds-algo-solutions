/*
Solution: In this problem, we create a 2D array (dp array) which stores the maximum possible value 
corrosponding to different values of k(ranging from 0 to k).

Now, we simulate through the 2D array and for any index i,j:
    We check if we can include the arr[i-1] or not.
    We check this by the following condition,

        dp[i][j] = max( dp[i-1][j], arr[i-1] + dp[i][j-arr[i-1]] );

To understand the above condition in depth, refer to :
https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

*/


#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the unboundedKnapsack function below.
int unboundedKnapsack(int k, vector<int> arr) {
    int n = arr.size();
    vector< vector<int> > dp(n+1,vector<int>(k+1,0));
    
    for(int i=1;i<n+1;i++){
        for(int j=1;j<k+1;j++){
            if(arr[i-1]<=j){
                dp[i][j] = max( dp[i-1][j], arr[i-1] + dp[i][j-arr[i-1]] );
            }
            
            else{
                dp[i][j] = dp[i-1][j];
            }
        }    
    }
    
    return dp[n][k];
}

int main()
{
    int t;
    cin>>t;
    
    while(t--){
        int n,k;cin>>n>>k;
        vector<int> v(n);
        for(int i=0;i<n;i++){
            cin>>v[i];
        }
        
        cout<<unboundedKnapsack(k,v)<<"\n";
    }
}
