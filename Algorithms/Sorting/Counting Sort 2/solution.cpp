#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
vector<int> countingSort(vector<int> arr) {
    
    // find max element in arr to give the index range
    // in this prolem max = 100
    int max = *max_element(arr.begin(), arr.end()) + 1;
    vector<int> index(max, 0);
    vector<int> result;
    
    // count frequency of arr elements
    for(int i = 0; i < arr.size(); i++){
        index[arr[i]]++;
    }
    
    // if frequency == 0 ---> element is not in the array
    for(int i = 0; i < index.size(); i++){
    
        if(index[i] > 0)
        {
          // if frequency > 0
          // push i , frequency times
          for(int j = index[i]; j > 0; j--){
              result.push_back(i);
          }  
        }
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

    vector<int> result = countingSort(arr);

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

