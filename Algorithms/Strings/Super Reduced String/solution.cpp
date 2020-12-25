#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string superReducedString(string s) {
    
    // traversing all characters of string s
    for(int i = 0; i < s.size(); ){
        // checking if consecutive characters are same
        if(s[i + 1] == s[i]){
            // if same then delete the pair of same characters i.e ith and (i+1)th
            // on deleting ith character first then new position of (i+1)th change to ith
            s.erase(s.begin() + i);
            s.erase(s.begin() + i);
            // again start from 0, and check again
            i = 0;
        }else{
            i++;
        }    
    }

if(s.size() != 0)
    return s;
else
    return "Empty String";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = superReducedString(s);

    fout << result << "\n";

    fout.close();

    return 0;
}

