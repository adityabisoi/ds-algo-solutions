#include <bits/stdc++.h>

using namespace std;

vector<int> rotated(vector<int> v, int d)
{
    int N = v.size();//Returns size of vector
    vector<int> a(N);
    for (int i = 0; i < N; i++)
    {
        a[(i - d + N) % N] = v[i];//We can visualise each element of arrays in a circle and left roatation is like anticlockwise rotation in that circle
    }
    return a;//returns the desired vector
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
