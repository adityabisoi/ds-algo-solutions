#include <bits/stdc++.h>

using namespace std;

//  the hourglassSum function below.
int hourglassSum(vector<vector<int>> arr) {
    int i=0;
    int ans=INT_MIN;
    while(i<arr.size()-2){
        for(int j=1; j<arr[i].size()-1; j++){
            // adding all the elements of hourglass
            int sum=arr[i][j-1]+arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j-1]+arr[i+2][j]+arr[i+2][j+1];
            //comparing ans with current hourglass sum
            ans=max(ans,sum);
        }
        i++;
    }
    return ans;
}

int main()
{

    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

    }
    int result = hourglassSum(arr);
    cout << result << "\n";

    return 0;
}
