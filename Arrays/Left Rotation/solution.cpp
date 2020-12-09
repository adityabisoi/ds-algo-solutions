#include <bits/stdc++.h>

using namespace std;

vector<int> rotated(vector<int> v, int d)
{
    int N = v.size();
    vector<int> a(N);
    for (int i = 0; i < N; i++)
    {
        a[(i - d + N) % N] = v[i];
    }
    return a;
}

int main()
{
    int N, d;
    cin >> N >> d;
    vector<int> a(N);
    for (int i = 0; i < N; i++)
    {
        cin >> a[i];
    }
    vector<int> b = rotated(a, d);

    for (int i = 0; i < N; i++)
    {
        cout << b[i] << " ";
    }
}
