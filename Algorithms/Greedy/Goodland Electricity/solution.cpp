#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
int pylons(int k, vector<int> arr) {
    
    // initial number of build tower = 0
    // flag = 1 means we build tower for flag = 0 unable to build
    int count = 0, flag;
    
    // traversing all cities
    // initally there will be no tower for given range of cities 
    for(int i = 0; i < arr.size(); ){
        flag = 0;
        
        // now we build only one tower where arr[j] = 1,
        // and this tower will build in range of [i-k+1, i+k-1]  
        for(int j = i + k - 1; j >= i -  k + 1 && j >= 0; j--){
           // when we found arr[j] = 1
           // increment number of tower and increase i by k, (need minimum number of towers)
            if(arr[j] == 1){
                count++;
                i = j + k;
                flag = 1;
                break;
            }
        }
        if(flag == 0)
        return -1;
    }
    return count;

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

    int result = pylons(k, arr);

    fout << result << "\n";

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

