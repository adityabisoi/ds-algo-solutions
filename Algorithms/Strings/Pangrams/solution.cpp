#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string pangrams(string s) {
    
    //Intialize a vector of size 26 (number of letters) to 0
    vector<int> alpha(26 , 0);
    
    // traversing each letter of string s
    // get ascii value of each letter
    // if ascii value is in [65 - 90] ---> letter -> [A-Z]
    // if ascii value is in [97 - 122] ---> letter -> [a-z]
    for(int i = 0; i < s.size(); i++){

            int ascii = s[i], index;
            // considering small letter and capital letter as same
            // making capital ---> small
            // to get index from 0 subtract ascii value with 97
            if(ascii < 96)
            ascii = ascii + 32;
            index = ascii - 97;
            alpha[index] = 1;
    }
    
    // considering 
    // alpha[0] = 1 -----> a/A is present, if 0 then absent
    // alpha[1] = 1 -----> b/B is present
    // and so on.
    for(int i = 0; i < 26; i++){
        if(alpha[i] != 1)
         return "not pangram";
    }
    
    return "pangram";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = pangrams(s);

    fout << result << "\n";

    fout.close();

    return 0;
}

