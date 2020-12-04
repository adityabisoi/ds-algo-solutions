#include <bits/stdc++.h>

using namespace std;

vector<int> rotateLeft(int d, vector<int> arr) {
    int n=arr.size();
    vector<int>ans;
    d=d%n;
    int start=d;
    while(start<n){
        ans.push_back(arr[start]);
        start++;
    }
    int i=0;
    while(i<d){
        ans.push_back(arr[i]);
        i++;
    }
    return ans;
}

int main()
{

    int t;
    cin>>t;
    while(t--){
        int n,d;
        cin>>n>>d;
        vector<int> arr(n);

        for (int i = 0; i < n; i++) {
            int a;
            cin>>a;
            arr.push_back(a);
        }

        vector<int> result = rotateLeft(d, arr);

        for (int i = 0; i < result.size(); i++) {
            cout << result[i]<<" ";
        }

        cout << "\n";
    }

    return 0;
}
