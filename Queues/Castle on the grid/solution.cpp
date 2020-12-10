#include <bits/stdc++.h>

using namespace std;
typedef pair<int, int> Node;
struct NodeDistance 
{
    Node node;
    int distance;
};
const int DIR_X[] = {0, 1,  0, -1};
const int DIR_Y[] = {1, 0, -1,  0};
vector<string> split_string(string);

// Complete the minimumMoves function below.
int minimumMoves(vector<string> grid, int startX, int startY, int goalX, int goalY) {

Node start(startX,startY), end(goalX,goalY);

    int grid_size = int(grid.size());
    vector<vector<bool>> visited(grid_size, vector<bool>(grid_size));

    queue<NodeDistance> q_distances;

        //queue to keep track of nodes and their distances from starting point
    q_distances.push({start, 0});

    //mark as visited
    visited[start.first][start.second] = true;

    while (!q_distances.empty()) 
    {
        NodeDistance cnd = q_distances.front();
        q_distances.pop();

        //if destination node is reached
        if (cnd.node == end)
            return cnd.distance;

        int x = cnd.node.first;
        int y = cnd.node.second;

        for (int dir = 0; dir < 4; dir++) 
        {
            int dx = DIR_X[dir], dy = DIR_Y[dir];
                //move when the node is not blocked by X
            for (int i = x + dx, j = y + dy;
                 i < grid_size && i >= 0 && j < grid_size && j >= 0 && grid[i][j] == '.';
                 i = i + dx, j = j + dy) 
            {
                //mark as visited
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    q_distances.push({{i, j}, cnd.distance + 1});
                }
            }
        }
    }
    return -1;
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

    string startXStartY_temp;
    getline(cin, startXStartY_temp);

    vector<string> startXStartY = split_string(startXStartY_temp);

    int startX = stoi(startXStartY[0]);

    int startY = stoi(startXStartY[1]);

    int goalX = stoi(startXStartY[2]);

    int goalY = stoi(startXStartY[3]);

    int result = minimumMoves(grid, startX, startY, goalX, goalY);

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
