#include <bits/stdc++.h>

using namespace std;

// Implementation Part
void kaprekarNumbers(int p, int q) {

// as only few numbers are kaprekar in range [1, 100000],
// it efficent to store and then check
vector<int> knum = {1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4950, 5050, 7272, 7777, 9999, 17344, 22222, 77778, 82656, 95121, 99999};

// variable used if there is no Knum in [p, q]
int flag = 0;
// traverse knum vector and check whether any number belongs to [p, q]
// if belongs print it
for(int i = 0; i <= knum.size(); i++){
    if(knum[i] >= p && knum[i] <= q){
        flag = 1;
        cout << knum[i] << " ";
    }
}

// if no number is printed till now
// print 'INVALID RANGE'
    if(!flag)
    cout << "INVALID RANGE" << endl;
}

int main()
{
    int p;
    cin >> p;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    kaprekarNumbers(p, q);

    return 0;
}

