#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
vector<int> largestPermutation(int k, vector<int> arr) {
    
    int i, j = 0, n = arr.size();
    
    // As elements are 1 2 3........n in arr
    // so we check if arr[i] is not n - i,
    // then find n -i and  swap it with arr[i]
    for(i = 0; i < n; i++)
    {
        if(arr[i] != n - i && k != 0)
        {
            j = i + 1;
            
            // finding (n - i) in arr
            // swap (n - i) with arr[i]
            while(arr[j] != n - i)
            j++;
            swap(arr[i], arr[j]);
            k--;
        }
    }
    return arr;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nk_temp;
    getline(cin, nk_temp);

    vector<string> nk = split_string(nk_temp);

    int n = stoi(nk[0]);

    int k = stoi(nk[1]);

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split_string(arr_temp_temp);

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    vector<int> result = largestPermutation(k, arr);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << " ";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}

