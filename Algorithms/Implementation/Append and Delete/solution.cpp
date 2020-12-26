#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string appendAndDelete(string s, string t, int k) {

   int count, i;
   // count common letters of s and t
    for(i = 0; s[i], t[i]; i++)
        if(s[i] != t[i])        
        break;
   
    // calculate number of letters to be change after extraction of common letters     
    int n1 = s.size(), n2 = t.size();
    count = n1 - i + n2 - i;
    
    // if limit of operations greater than number of letters to be change
    // or limit >= totalsize of (s + t)
    if(k == count || k >= n1 + n2)      
    return "Yes";
    // another case 
    // intentionally delete and append to reach upto k operations
    else if(count % 2 == k % 2 && count <= k) 
    return "Yes";
    else              
    return "No";          
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string t;
    getline(cin, t);

    int k;
    cin >> k;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string result = appendAndDelete(s, t, k);

    fout << result << "\n";

    fout.close();

    return 0;
}

