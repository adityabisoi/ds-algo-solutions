#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implemetation Part
vector<int> cutTheSticks(vector<int> arr) {
    
    // sort vector in decreasing order
    // push first element as size of arr
    sort(arr.begin(), arr.end(), greater<int>());
    int count, s = arr.size();
    vector<int> result;
    result.push_back(s);
    
    // check if first or largest element in arr is > 0
    // subtract each element by last or minimum elemet of arr
    while(arr[0] > 0){
        count = 0;
        for(int i = 0; i < s; i++){
            arr[i] -= arr[s-1];
            
            // if after subtraction it is not 0, then push count
            // else not
            // decrease size of arr whenever element becomes 0 
            if(arr[i] == 0){
                count = i;
                break;
            }
        }
        if(count != 0)
        result.push_back(count);
        s = count;
    }

return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split_string(arr_temp_temp);

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    vector<int> result = cutTheSticks(arr);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
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

