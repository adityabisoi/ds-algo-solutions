#include <bits/stdc++.h>

using namespace std;

// Complete the reverseShuffleMerge function below.
string reverseShuffleMerge(string s) {
    int n = s.length();
    vector<char> ch(s.rbegin(), s.rend()); //string each character of s in vector but in reverse order
    vector<int> freq(26, 0);
    // counting the frequency of each character
    for (int i = 0; i < n; i++) {
        freq[ch[i] - 'a']++;
    }
    vector<int> used(26, 0); 
    vector<int> cused(freq.begin(), freq.end());
    vector<char> A; // This will store the character of the smallest string
    for (int i = 0; i < n; i++) {
        // store the string which is the lexicographically smallest valid S
        if (used[ch[i] - 'a'] < freq[ch[i] - 'a'] / 2) {
            while (A.size() > 0 && ch[i] < A.back() 
                   && used[A.back() - 'a'] + cused[A.back() - 'a'] - 1 
                   >= freq[A.back() - 'a'] / 2) {
                used[A.back() - 'a']--;
                A.pop_back();
            }
            A.push_back(ch[i]);
            used[ch[i] - 'a']++;
            cused[ch[i] - 'a']--;
        } else {
            cused[ch[i] - 'a']--;
        }
    }
    return string(A.begin(), A.end()); // return string which is the lexicographically smallest valid s

}

int main()
{

    string s;
    cin>>s;

    string result = reverseShuffleMerge(s);

    cout << result << "\n"; //printing the output

    return 0;
}
