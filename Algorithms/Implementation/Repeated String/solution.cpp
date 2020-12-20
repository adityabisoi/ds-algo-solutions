#include <bits/stdc++.h>

using namespace std;

// Implementation Part
long repeatedString(string s, long n) {

    // calculate size of string s
    // initialize count of a's = 0 at starting
    // A will find how many times we need to repeat s
    long size = s.size();
    long count = 0;
    long A = (n / size);

    // count a's in string s
    for(long i = 0; i < s.size(); i++){
        if(s[i] == 'a')
            count++;
    }

    // Case: 1
    if(A * size == n)
        return (A * count);
    // Case: 2
    else{
        
        // get size remaining = n - A * size
        // count a's in remaining size
        long result = A * count;
            size = n - A * size;
            for(long i = 0; i < size; i++){
            if(s[i] == 'a')
            result++;
    }
    return result;
    }
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    long n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    long result = repeatedString(s, n);

    fout << result << "\n";

    fout.close();

    return 0;
}

