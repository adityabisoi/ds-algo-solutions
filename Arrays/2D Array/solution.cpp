#include <bits/stdc++.h>

using namespace std;

// Complete the hourglassSum function below.
int hourglassSum(vector<vector<int>> arr) // a 2-D vector array
{

    int sum, max = -99999, c = 0;             // max =-99999 so that we can take the -ve  value also
    for (int i = 0; i <= arr.size() - 3; i++) // one loop for the rows in thr grid
    {
        for (int j = 0; j <= arr.size() - 3; j++) // one loop for the colums in thr grid
        {                                         // i and j are limited to arr.size() -3 because after that the hourglass will not exist
            sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
            sum = sum + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
            // sum has the value of the every hourglass possible in the grid.
            // it gets updated after every itreation.

            if (sum > max)
                max = sum; //among all the sum possible this takes the maximum value
        }
    }

    return max; // returning the maximum value
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++)
    {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++)
        {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = hourglassSum(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
