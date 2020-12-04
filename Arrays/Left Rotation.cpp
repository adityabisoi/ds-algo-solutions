#include <bits/stdc++.h>

using namespace std;

void leftRotateByOne(int arr[],int n){
    int temp = arr[0], i;
    for(i=0;i<n-1;i++){
        arr[i] = arr[i+1];
        //cout << arr[i] << " ";
    }
    arr[i] = temp;
}

void leftRotate(int arr[],int n,int d){
    for(int i=0;i<d;i++){
        leftRotateByOne(arr, n);
    }
}

int main()
{
    int n, d;
    cin >> n >> d;
    int arr[n];
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }
    leftRotate(arr, n, d);
    for(int i=0;i<n;i++){
        cout << arr[i] << " ";
    }
    return 0;
}
