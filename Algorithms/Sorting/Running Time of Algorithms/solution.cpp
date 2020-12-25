#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
int runningTime(vector<int> arr) {
    
    int i, j, count = 0, result;
    int value;
    
    // Insertion Sort
    // for each element in arr ---> find it's correct position
    for(i = 1; i < arr.size(); i++)
    {
        value = arr[i];
        count = 0;
        j = i - 1;
        
        // finding position of element
        // shiflt all elements to left 
        // count all shifts
        while(j >= 0 && value < arr[j])
        {
            arr[j + 1] = arr[j];
            j = j - 1;
            count++;
        }
        
        // final position of value
        // if count == 0 ===> element is already at it's correct position
        // no need to shift
        arr[j + 1] = value;
        if(count != 0)
        result += count;
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

    int result = runningTime(arr);

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

