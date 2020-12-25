#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int gemstones(vector<string> arr) {
    
    // array a is of letters
    // array flag ---> whether letter is present or not in a particular word
    int a[26] = {0};
    bool flag[26] = {false};

    // traversing each string of vector arr
    for(int j = 0; j < arr.size(); j++){
        
        string str = arr[j];
        for(int i = 0; i < str.size(); i++)
        {
            // get index to point that str[i] is presesnt in str
            // then increase value of a at that index by 1
            // as letters can be repeated in same word so for that,
            // we use flag  
            int ch = (int)str[i] - 97;
            if( ch >= 0 && ch < 26 && flag[ch] == false)    
            {        
                a[ch]++;
                flag[ch] = true;
            }
            
        }
        
        // make all values of flag --> false
        // again use same algorithm
        for(int i = 0; i < 26;i++)
        flag[i] = false;
    }
    
    // count value == arr.size in array a
    // as we incremented value of a when letter is present in string
    int count = 0;
    for(int i = 0; i < 26; i++){
        if(a[i] == arr.size())
        count++;
    }
    
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<string> arr(n);

    for (int i = 0; i < n; i++) {
        string arr_item;
        getline(cin, arr_item);

        arr[i] = arr_item;
    }

    int result = gemstones(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}

