#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string twoStrings(string s1, string s2) {
    
    // traverse each letter of string s1
    for(int i = 0; i < s1.size(); i++){
            // check if current letter of s1 found in s2
            // if found that means we have atleast one length substring
            // npos ---> not found 
            if(s2.find(s1[i]) != string::npos)
            return "YES";
    }  
    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s1;
        getline(cin, s1);

        string s2;
        getline(cin, s2);

        string result = twoStrings(s1, s2);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

