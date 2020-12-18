#include <bits/stdc++.h>

using namespace std;

// Implentation Part
int findDigits(int n) {
    
    // first make num == n so that we can use num
    // initially, number of divisors = 0
    // in loop while num > 0
    int num = n, x, count = 0;
    while(num > 0){
        
        // find last digit of num
        // check whether it divides n or not
        x = num % 10;
        
        // if x divides n
        // increase count by 1
        if(x != 0 && n % x == 0)
         count++;
         num = num / 10;
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int t_itr = 0; t_itr < t; t_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        int result = findDigits(n);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

