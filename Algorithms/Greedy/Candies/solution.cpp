#include <bits/stdc++.h>

using namespace std;

// Implementation Part
long candies(int n, vector<int> arr) {
    
   // give 1 candie to every child
    vector<int> candies(n, 1);
    
    // provide candies from left ---> right
    for(int i = 1; i < n; i++) {
        // if rating of ith child is greater than (i-1)th child
        if(arr[i] > arr[i-1]) {
            candies[i] += candies[i-1];
        }
    }
    
    // provide candies from right ---> left
    for(int i = n-2; i >= 0; i--) {
        // provide more candies only those whoever have greater rating
        if(arr[i] > arr[i+1] && candies[i] < candies[i+1]+1) {
            candies[i] = candies[i+1]+1;
        }
    }
    // sum of all candies which will be provided to the children
    long long result = 0;
    for(int i = 0; i < n; i++) {
        result += candies[i];
    }
    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item;
        cin >> arr_item;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        arr[i] = arr_item;
    }

    long result = candies(n, arr);

    fout << result << "\n";

    fout.close();

    return 0;
}

