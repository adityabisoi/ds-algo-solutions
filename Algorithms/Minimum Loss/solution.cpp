#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<double> sorted(n);
    map<double, int> arr;
    for (int i = 0; i < n; ++i) {
        double x;  
        cin >> x;
        sorted[i] = x;
        arr[x] = i;
    }
    //we have to sort the prices first
    sort(sorted.begin(), sorted.end());
    double min = INT_MAX;
    for (int i = 0; i < n - 1; ++i) {
        //check the difference of the adjacent pairs, if it is less than last min then update min, if index of those pairs are in the same order as original array
        double x = sorted[i + 1] - sorted[i];
        if (x < min) {
            int first = arr[sorted[i]];
            int second = arr[sorted[i + 1]];
            if (second < first) {
                min = x;
            }
        }
    }
    cout << long(min);
    return 0;
}
