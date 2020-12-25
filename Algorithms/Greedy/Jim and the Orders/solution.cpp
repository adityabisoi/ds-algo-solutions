#include <bits/stdc++.h>

using namespace std;

// Implementation Part
vector<int> jimOrders(vector<vector<int>> orders) {

    vector<int> serve;
    int time;
    
    // traverse orders,
    // calculate sum f order and time
    // store that sum to serve
    for(int i = 0; i < orders.size(); i++){
        time = orders[i][0] + orders[i][1];
        serve.push_back(time);
    }
    
    // make del equal to serve
    // sort del, to find order of delivery
     vector<int> del = serve;
     sort(del.begin(), del.end()); 
    
    // find index of del[i], i.e lowest delivery time
    // in serve and use (index + 1)
    for(int i = 0; i < serve.size(); i++){
           int pos = find(serve.begin(), serve.end(), del[i]) - serve.begin();
           serve[pos] = -1;
           del[i] = pos + 1;
    }
    return del;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<vector<int>> orders(n);
    for (int i = 0; i < n; i++) {
        orders[i].resize(2);

        for (int j = 0; j < 2; j++) {
            cin >> orders[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    vector<int> result = jimOrders(orders);

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

