#include <bits/stdc++.h>

using namespace std;

// check palindrome of string from start to end
bool isPalindrome(string s, int start, int end) {
    
    for (int i = start, j = end; i < j; i++, j--) {
        if (s[i] != s[j])
            return false;
    }
    return true;
}

// Implementation Part
int palindromeIndex(string s) {  
    
    // traverse from start and back
    for (int i = 0, j = s.length()-1; i < j; i++, j--) {
        // check when ith and corresponding jth character are not same
        if (s[i] != s[j]) {
            // skip i th character and check again if it palindrome then,
            // remvve ith letter from start
            if (isPalindrome(s, i+1, j))
                return i;
            
            // skip jth character and check is it palindrome, if it is then,
            // remove jth letter from back
            if (isPalindrome(s, i, j-1))
                return j;

            // if it is palindrome then no need to remove anything 
            return -1;
        }
    }

    return -1;
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

        int result = palindromeIndex(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

