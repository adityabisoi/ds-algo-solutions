#include<bits/stdc++.h>

using namespace std;

// checks all positions in the grid where it's possible to place the strings
bool placeString(vector<string>& grid, const string& l) {

    int len = l.length();
    bool placed = false;
    
    // check the horizontal positions
    // checking each row
    for (int i = 0; i < 10; i++) {       
        if (placed)
            break;
        else
            placed = true;
        // checking each part of the row
        for (int j = 0; j <= (10 - len); j++) {    
            placed = true;

            for (int k = j; k < (len + j); k++) {

                // wasn't able to be placed here, break
                if (grid[i][k] == '+') {
                    placed = false;       
                    break;
                } else if (grid[i][k] == '-') {
                // Continue
                } else if (l[k - j] != grid[i][k]) {
                // wasn't able to be placed here, break
                    placed = false;        
                    break;
                }

            }
            
            // if placed, update grid nd break
            if (placed) {                   
                for (int k = j; k < (len + j); k++)
                    grid[i][k] = l[k - j];
                break;
            }
        }
    }

    // check the vertical positions
    if (!placed) {
        
        // now check each column
        for (int i = 0; i < 10; i++) {           
           
            if (placed)
                break;
            else
                placed = true;
            
            // check each position in the column
            for (int j = 0; j <= (10 - len); j++) {   

                placed = true;
                for (int k = j; k < (len + j); k++) {

                    if (grid[k][i] == '+') {
                        placed = false;    
                        break;
                    } else if (grid[k][i] == '-') {
                        
                    } else if (l[k - j] != grid[k][i]) {
                        placed = false;   
                        break;
                    }
                }

                if (placed) {               
                    for (int k = j; k < (len + j); k++)
                        grid[k][i] = l[k - j];
                    break;
                }
            }
        }
    }

    return placed;
}

// tries to place the strings in the given order
vector<string> finishGrid(vector<string> grid, vector<string> placesNames) {

    vector<string> completedGrid;
    int len = placesNames.size();

    bool success = true;
    for (int i = 0; i < len; i++) {
        string l = placesNames[i];

        if (!placeString(grid, l)) {

            success = false;
            completedGrid.push_back("nope");
            break;
        }

    }

    if (success)
        completedGrid = grid;
    return completedGrid;
}

// Driver Code
int main() {

// Input of grid and String of words
    vector<string> grid;
    string s;

    for (int i = 0; i < 10; i++) {
        cin >> s;
        grid.push_back(s);
    }

    cin >> s;
    vector<string> placesNames;
    int len = s.length();
    int start = 0;
    
    // find ; as words are seperated by ; only
    // initialing word to temp
    for (int i = 0; i < len; i++) {
        if (s[i] == ';') {
            string temp(s.begin() + start, s.begin() + i);
            placesNames.push_back(temp);
            start = i + 1;
        }
    }

    string temp(s.begin() + start, s.end());
    placesNames.push_back(temp);
    
    // sorting the letters of word
    sort(placesNames.begin(), placesNames.end());
    vector<string> finishedGrid;

    // run loop for all permutations
    do {
        finishedGrid = finishGrid(grid, placesNames);
        if (finishedGrid[0] != "nope")
            break;
    } while (next_permutation(placesNames.begin(), placesNames.end()));

    // Display output
    for (int i = 0; i < 10; i++)
        cout << finishedGrid[i] << endl;
        
    return 0;
}

