#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    //take input n (number of integers);
    int n;
    cin >> n;

    //create a vector to store the integers
    vector<int> a(n);
    
    //take input of n numbers using a loop
    for(int i = 0; i < n; i++) {
        cin >> a[i];
        //as we need square of each number, multiply the number with itself
        a[i] *= a[i];
    }
    
    //Finally, sort the array which now contains the squares of individual elements using the inbuilt sort function 
    sort(a.begin(), a.end());
    
    //Print the sorted array
    for(int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << '\n';
    return 0;
}