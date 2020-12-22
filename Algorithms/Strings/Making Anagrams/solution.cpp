#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int makingAnagrams(string s1, string s2) {
    
    // creating vector for finding frequency of letters
    vector<int> freq(26, 0);
    
    // Get the frequency of each letter in s1
    for(int i = 0; i < s1.size(); i++){
        int index = (int)s1[i] - 97;
        freq[index]++;
    }
    
    // getting difference of frequency of letters in s1 and s2
    for(int i = 0; i < s2.size(); i++){
        int index = (int)s2[i] - 97;
        freq[index]--;
    }
    
    /*
    * So if frequency is 0 thet means letter has same frequency in s1 and s2
    * no need to delete
    * if frequency is not zero...we need to delete that element
    */
    int count = 0;
    for(int i = 0; i < 26; i++)
        count += abs(freq[i]);
        
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s1;
    getline(cin, s1);

    string s2;
    getline(cin, s2);

    int result = makingAnagrams(s1, s2);

    fout << result << "\n";

    fout.close();

    return 0;
}

