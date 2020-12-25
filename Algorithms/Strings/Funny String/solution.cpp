#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string funnyString(string s) {
    
    // make r string as a reverse of s
    string r = s;
    reverse(r.begin(), r.end());
    
    // traverse each letter of s and r
    // taking absolute differnce of both ascii values
    // i.e current position and (current - 1)th position
    for(int i = 1; i < s.size(); i++){
        
        int diff_s = abs(s[i] - s[i - 1]);
        int diff_r = abs(r[i] - r[i - 1]);
        
        // if that differnce not same
        if(diff_r != diff_s)
            return "Not Funny";
        
    }
    return "Funny";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        string result = funnyString(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

