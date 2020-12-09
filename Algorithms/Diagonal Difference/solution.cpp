#include <bits/stdc++.h>

using namespace std;

/*
 * the 'diagonalDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 * 
 * Complexity: BigO(n);
 * 
 * What we do is traversing one diagonal at a time, because traversin 2 diagonals in onemay complicate things
 * 
 * In first loop, we traverse from left top to right bottom whereas 
 * in 2nd loop we will traverse from right top to bottom left
 */

int diagonalDifference(vector<vector<int>> arr) {
    int s1=0; //sum of diagonal from left top to right bottom
    int n=arr[0].size(); //size of square matrix
    int i=0;
    //loop 1
    while(i<n){
        s1=s1+arr[i][i];
        i++;
    }
    //loop 2
    int s2=0,j=n-1; //sum of diagonal from right top to left bottom
    i=0;
    while(i<n){
        s2=s2+arr[i][j];
        i++;
        j--;
    }
    return abs(s2-s1); //difference of solution;
}

int main()
{
    int n;
    cin>>n;

    vector<vector<int>> arr(n);

    for (int i = 0; i < n; i++) {
        arr[i].resize(n);

        for (int j = 0; j < n; j++) {
            int a;
            cin>>a;

            arr[i][j] = a;
        }
    }

    int result = diagonalDifference(arr);

    cout << result << "\n";

    return 0;
}
