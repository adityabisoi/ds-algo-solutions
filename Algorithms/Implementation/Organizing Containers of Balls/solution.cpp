/*

Solution: The logic in this problem is that after all the swap operations, the number of balls inside the
container reamins the same.
So, all we have to do is to check if there exists a ball whose ball_count is equal to a particular container's
capacity. If it exists, then we will similarly check for remaining balls. Otherwise, we return "Impossible".

So,
1. Create two array (capacity, ball_count) and fill those arrays by traversing the 2-D matrix.
2. Sort the two arrays and check if they are the same or not.
3. If they are same, return "Possible", else return "Impossible".

*/


#include <bits/stdc++.h>

using namespace std;

// Complete the organizingContainers function below.
string organizingContainers(vector<vector<int>> container) {
    int n = container.size();
    vector<int> capacity(n,0);
    vector<int> ball_count(n,0);
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            capacity[i] += container[i][j];
        }
    }
    
    for(int j=0;j<n;j++){
        for(int i=0;i<n;i++){
            ball_count[j] += container[i][j];
        }
    }
    
    sort(capacity.begin(),capacity.end());
    sort(ball_count.begin(),ball_count.end());
    
    if(capacity==ball_count) return "Possible";
    else return "Impossible";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        vector<vector<int>> container(n);
        for (int i = 0; i < n; i++) {
            container[i].resize(n);

            for (int j = 0; j < n; j++) {
                cin >> container[i][j];
            }

            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }

        string result = organizingContainers(container);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
