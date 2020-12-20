/*
Approach~
n=0: Initial grid
n=1: After one second, Bomberman does nothing. Thus return the same initial grid.
n=2: Bomerman fills the whole grid with bombs.
n=3: Initial grid bombs(n=0) detonate & detonate time for bomb set at n=2 decreases by 1.

n=4: Again fill the whole grid.
n=5: Bomb set at n=2 detonates & detonate time for bomb set at n=4 decreases by 1.

n=6: Again fill the whole grid.
n=7: Bomb set at n=4 detonates & detonate time for bomb set at n=6 decreases by 1.
.
.
.
So we see at n=2,4,6,8... i.e n%2==0, The whole grid is covered with bombs(grid_0 in code)

We also see the grid we get at n=3 repeats after every 4 second. Thus at {n|n%4==3} i.e n=3,7,11... the grids obtained are same(grid_3 in code)

Similarly grids at {n|n%4==1} i.e n=4,9,13 are all same(grid_5 in code)

*/
#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);
vector<string> bomberMan(int n, vector<string> grid) {
    
    int r=grid.size();             //No.of rows in  the grid
    int c;
    for(c=0;grid[0][c]!='\0';c++); //No.of columns in the grid i.e length of a string stored in 'c'

    vector<string> grid_0;         //grid at n=2,4,6...
    vector<string> grid_3;         //grid at n=3
    vector<string> grid_5;         //grid at n=5

    string temp="";                //variable to store 'c' length string  containing all Os
    for(int i=0;i<c;i++){
        temp+='O';
    }
    //Fill grid_0 with all Os
    for(int i=0;i<r;i++){
                grid_0.push_back("");
                grid_3.push_back("");
                grid_5.push_back("");
                grid_0[i]=temp;
                grid_3[i]=temp;
                grid_5[i]=temp;
                
    }
    //after one second, Bomberman does nothing(No change)
    if(n==1)
        return grid;

    //at t=2,4,6... Bomerman fills the whole grid with bombs
    else if(n%2==0){
        return grid_0;
    }

    else{
        //calculate grid_3
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='O'){
                    grid_3[i][j]='.';
                    if(i-1 >=0)
                        grid_3[i-1][j]='.';
                    if(i+1<r)
                        grid_3[i+1][j]='.';
                    if(j-1 >=0)
                        grid_3[i][j-1]='.';
                    if(j+1<c)
                        grid_3[i][j+1]='.';
                                
                }
            }
        }

        if(n%4==3){    //3,7,11...
            return grid_3;
        }
        else{                           //n%4==1, i.e 5,9,13...
            //calculate grid_5
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(grid_3[i][j]=='O'){
                        grid_5[i][j]='.';
                        if(i-1 >=0)
                            grid_5[i-1][j]='.';
                        if(i+1<r)
                            grid_5[i+1][j]='.';
                        if(j-1 >=0)
                            grid_5[i][j-1]='.';
                        if(j+1<c)
                            grid_5[i][j+1]='.';
                                    
                    }
                }
            }
            return grid_5;
        }
    }
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string rcn_temp;
    getline(cin, rcn_temp);

    vector<string> rcn = split_string(rcn_temp);

    int r = stoi(rcn[0]);

    int c = stoi(rcn[1]);

    int n = stoi(rcn[2]);

    vector<string> grid(r);

    for (int i = 0; i < r; i++) {
        string grid_item;
        getline(cin, grid_item);

        grid[i] = grid_item;
    }

    vector<string> result = bomberMan(n, grid);

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


