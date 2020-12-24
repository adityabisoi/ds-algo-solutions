#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int theLoveLetterMystery(string s) {
    
    /*
    * In palindrome string is same as initial when you reverse it
    * to make string same as when you reverse it
    * Suppose example:
    * abcdef ----> fedcba
    * change def ---> cba, i.e change to it's coreesponding element position
    */
    int n  = s.size(), count = 0;
    for(int i = 0, j = n - i -1; i < j; i++, j--){
        
        // to change it get ascii code of left letter and right letter
        // then take absolute difference of it
        int left = (int)s[i];
        int right = (int)s[j];
        count += abs(left - right);
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
        string s;
        getline(cin, s);

        int result = theLoveLetterMystery(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

