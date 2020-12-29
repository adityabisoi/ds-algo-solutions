//divisibleSumPairs in C++

/*
    This seems very hard question when read but due to constarints this can be done by applying bruteforce

    Traverse the array make possible pair of i & j such that j is always greater than i
*/

#include<bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the divisibleSumPairs function below.
int divisibleSumPairs(int n, int k, vector<int> ar) {
    int count=0; // to store count of such pairs
    //Traverse through the array
    for(int i=0;i<n; i++){
        int j=i+1;
        // make sure j is greater than i
        while(j<n){
            // if sum of elements present at index at i & j is divisible by k increase the count
            if((ar[i]+ar[j])%k==0){
                count++;
            }
            j++;
        }
    }
    return count; // return the answer

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
