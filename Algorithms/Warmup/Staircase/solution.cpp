#include <bits/stdc++.h>

using namespace std;

// Implementation Part
void staircase(int n) {

    // for n height, use loop for each row
    for (int i = 1; i <= n; i++) {
        // first print (n-1) spaces for each row 
        for (int j = 1; j <= (n - i); j++){
            cout << " ";    
        }
        
        // print # for k times, where k is row
        for (int k = 1; k <= i; k++){
            cout << "#";    
        }
        cout << endl;
  }

}

int main()
{
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    staircase(n);

    return 0;
}

