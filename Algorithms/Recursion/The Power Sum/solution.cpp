#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int powerSum(int X, int N, int S) {
    
    // Recursive approach
    // start from 1 and check until j ^ N <= X
    // recall same function with updated argument 
    int count = 0;
    if (X == 0) 
        return 1;
    // X ---> X - j ^ N and S ---> j
    // increase count on each return
    for (int j = S + 1; pow(j, N) <= X; ++j) 
        count += powerSum(X - pow(j, N), N, j);

    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int X;
    cin >> X;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int N;
    cin >> N;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int result = powerSum(X, N, 0);

    fout << result << "\n";

    fout.close();

    return 0;
}

