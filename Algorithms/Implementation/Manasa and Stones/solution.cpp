#include <bits/stdc++.h>

using namespace std;

// Implementation Paart
vector<int> stones(int n, int a, int b) {
    
    vector<int> vec;
    // when a == b only one value will be possible for last stone
    // so if a == b only value is a * (n - 1)
    if(a == b){
        vec.push_back(a * (n - 1));
        return vec;
    }
    
    // find max and min , in between a and b
    int max, min;
    if( a > b){
        max = a;
        min = b;
    }else{
        max = b;
        min = a;
    }
    
    // first minimum value possible for last stone
    int first = (n - 1) * min;
    // last maximum value possible for last stone
    int last = (n - 1) * max;
    // As possible values of last stone form A.P
    // with common difference = max - min
    int d = max - min;
    
    // all possible values for last stone 
    for(int i = first; i <= last ; i = i + d){
        vec.push_back(i);
    }
    
    return vec;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int T;
    cin >> T;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int T_itr = 0; T_itr < T; T_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        int a;
        cin >> a;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        int b;
        cin >> b;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        vector<int> result = stones(n, a, b);

        for (int i = 0; i < result.size(); i++) {
            fout << result[i];

            if (i != result.size() - 1) {
                fout << " ";
            }
        }

        fout << "\n";
    }

    fout.close();

    return 0;
}

