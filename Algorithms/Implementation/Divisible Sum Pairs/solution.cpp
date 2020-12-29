//divisibleSumPairs in C++

/*
    This seems very hard question when read but due to constarints this can be done by applying bruteforce

    Traverse the array make possible pair of i & j such that j is always greater than i
*/

#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the divisibleSumPairs function below.
int divisibleSumPairs(int n, int k, vector<int> ar) {
    int count=0; // to store count
        for(int i=0;i<n; i++){
            int j=i+1;
            while(j<n){
                if((ar[i]+ar[j])%k==0){
                    count++;
                }
                j++;
            }
        }
        return count;

}

int main()
{

    int n,k;
    cin>>n>>k;

    vector<int> ar(n);

    for (int i = 0; i < n; i++) {

        cin>>ar[i];
    }

    int result = divisibleSumPairs(n, k, ar);

    cout << result << "\n";

    return 0;
}
