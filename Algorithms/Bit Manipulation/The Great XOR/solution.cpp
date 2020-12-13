#include <bits/stdc++.h>
using namespace std;

// Implementation part
long theGreatXor(long x) {
    
    long count = 0, i = 0;
    while(x > 0){
        // on binary represtation of x
        // expected result = summation of 2 power of i
        // where i is index of 0's
        
        // check if modulo == 0 then add 2 power i to previous result
        if(x % 2 == 0){
            count += (long)pow(2, i);
        }
        // update x and i
        x = x / 2;
        i++;
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        long x;
        cin >> x;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        long result = theGreatXor(x);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

