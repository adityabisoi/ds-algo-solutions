/*
Solution: In this problem, we iterate through the first array(A) and for each element in A, we check 
for the same element in B (using the find function). If the same element exists in B, then we incrase the
count of our answer and then we delete that particular element(since, we should consider pairwise disjoint sets only)

And finally, after exiting the loop, we will check the number of elements in B.
1. If it is zero, then that means both A and B are exactly the same array and because, 
we have to change atleast one element, the answer would be n-1. (n: number of elements in A or B)

2. It it is non-zero, then our answer will be count + 1.
This is because, we can change one of the remaining elements in B, thus increasing the final answer by one.

*/




#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the beautifulPairs function below.
int beautifulPairs(vector<int> A, vector<int> B) {
    int ans = 0;
    for(int i=0;i<A.size();i++){
        auto itr = find(B.begin(),B.end(),A[i]);
        if(itr!=B.end()){
            ans++;
            B.erase(itr);
        }
    }
    
    if(B.size()==0){
        return A.size()-1;
    }
    
    return ans+1;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string A_temp_temp;
    getline(cin, A_temp_temp);

    vector<string> A_temp = split_string(A_temp_temp);

    vector<int> A(n);

    for (int i = 0; i < n; i++) {
        int A_item = stoi(A_temp[i]);

        A[i] = A_item;
    }

    string B_temp_temp;
    getline(cin, B_temp_temp);

    vector<string> B_temp = split_string(B_temp_temp);

    vector<int> B(n);

    for (int i = 0; i < n; i++) {
        int B_item = stoi(B_temp[i]);

        B[i] = B_item;
    }

    int result = beautifulPairs(A, B);

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
