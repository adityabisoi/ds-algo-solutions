#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int camelcase(string s) {
    
    // initalize count = 1 for first word
    // count all captial letter in given string
    // as ASCII code for [a-z] starts from 97,
    // for [A - Z] starts from 65
    int count = 1;
    for(int i = 0; i < s.size(); i++){
        
        // So for each capital letter
        // ASCII value  will be definitely less than 95
        if(int(s[i]) < 95)
        count++;
    }  
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    int result = camelcase(s);

    fout << result << "\n";

    fout.close();

    return 0;
}

