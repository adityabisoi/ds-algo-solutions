#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int maxMin(int k, vector<int> arr) {
    
    // initial value of unfairness = INT_MAX
    int d, min = INT_MAX;
    // sort arr in ascending order
    sort(arr.begin(), arr.end());
    k--;
    
    // traversing arr
    for(int i = 0; i < arr.size(); i++){
        
        if(i + k >= arr.size())
        break;
        // as elements are already sorted
        // minmized unfairness will provide by consecutive sorted elements
        // indexing from 0 so there will k elements in between i+k and i
        // so (i+k)th is largest element and ith is minimum element 
        d = arr[i + k] - arr[i];
        // updating minimum elemment
        if(d < min)
        min = d;
    }
    return min;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int k;
    cin >> k;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item;
        cin >> arr_item;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        arr[i] = arr_item;
    }

    int result = maxMin(k, arr);

    fout << result << "\n";

    fout.close();

    return 0;
}

