// Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters.
// If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by
// 3, w, x, y and z would map to z, a, b and c.

// Example Input
// 11
// middle-Outz
// 2
// Example Output
// okffng-Qwvb

// C++ program for Caesar cipher

#include <bits/stdc++.h>

using namespace std;

// Complete the caesarCipher function below.
string caesarCipher(string s, int k) {
string orig="abcdefghijklmnopqrstuvwxyz";
string big="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

int len=s.length(),ind,n=big.length();
for(int i=0;i<len;i++)
{
    if(isalpha(s[i]))
    {
        if(isupper(s[i]))
        {
            size_t found=big.find(s[i]);
            if(found!=string::npos)
            ind=found;
            s[i]=big[(ind+k)%n];
        }
        else
        {
        size_t found=orig.find(s[i]);
        if(found!=string::npos)
        ind=found;
        s[i]=orig[(ind+k)%n];
        }
    }
    else {
    continue;
    }
}
return s;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string s;
    getline(cin, s);

    int k;
    cin >> k;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string result = caesarCipher(s, k);

    fout << result << "\n";

    fout.close();

    return 0;
}
