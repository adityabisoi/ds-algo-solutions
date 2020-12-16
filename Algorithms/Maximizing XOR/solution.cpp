#include <bits/stdc++.h>

using namespace std;

// Complete the maximizingXor function below.
// Checking all the possibilities of l and r and xor them to get maximum of the XORs.

int maximizingXor(int l, int r) 
{
    int max_xor = -100000;
    // Using brute for approach

    for(int i =l;i<r;i++)
    {
        for(int j = l+1;j<=r;j++)
        {
            if((i^j)>max_xor)           // Checking if current XOR is greater than previous ones
            {
                max_xor = i^j;
            }
        }
    }
    return max_xor;                     // returning the maximum.
 
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int l;
    cin >> l;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int r;
    cin >> r;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int result = maximizingXor(l, r);

    fout << result << "\n";

    fout.close();

    return 0;
}
