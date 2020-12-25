#include <bits/stdc++.h>

using namespace std;

// Implementation Part
vector<string> cavityMap(vector<string> grid) {
    
    string str, strp;
    // traverse each value of grid i.e all strings
    for(int i = 1; i < grid.size() - 1; i++){

        for(int j = 1; j < grid[i].size() - 1; j++){
            // get adjacent numbers
            // left value 
            int l = (grid[i][j - 1]) - '0';
            // current value or mid value
            int m = (grid[i][j]) - '0';
            // right value
            int r = (grid[i][j + 1]) - '0';
            // upper value
            int u = (grid[i-1][j]) - '0';
            // down value
            int d = (grid[i+1][j]) - '0';
            
            // check if mid value is greater than from all
            // adjacent values then replace mid value with 'X'
            if( l < m && m > r && m > u && d < m)
                grid[i][j] = 'X';
            
        }
    }
    
    return grid;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<string> grid(n);

    for (int i = 0; i < n; i++) {
        string grid_item;
        getline(cin, grid_item);

        grid[i] = grid_item;
    }

    vector<string> result = cavityMap(grid);

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

