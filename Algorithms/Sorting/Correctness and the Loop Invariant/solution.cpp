#include <bits/stdc++.h>

using namespace std;

// Implementation Part
void insertionSort(int N, int arr[]) {
    
    int i, j;
    int value;
    // for each element in arr, find it's correct position
    // by shifing all elements to left
    // and finally swap it to correct position
    for(i = 1; i < N; i++)
    {
        value = arr[i];
        j = i - 1;
        
        // finding correct posiiton
        while(j >= 0 && value < arr[j])
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = value;
    }
    
    // Display Output
    for( j = 0; j < N; j++)
    {
        printf("%d",arr[j]);
        printf(" ");
    }
}

int main(void) {

    int N;
    scanf("%d", &N);
    int arr[N], i;
    for(i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    insertionSort(N, arr);

    return 0;
}
