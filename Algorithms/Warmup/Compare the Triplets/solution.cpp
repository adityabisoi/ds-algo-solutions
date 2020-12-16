#include <bits/stdc++.h>

using namespace std;

/*
We will compare each points one at a time, follow these three conditions

    1. If Alice has greater point then increase points of Alice
    2. If Bob has greater point then increase points of Bob
    3. If both of them same points no changes
*/
vector<int> compareTriplets(vector<int> a, vector<int> b) {
    int al=0,bo=0;  // al is Alice's points whereas bo is Bob's point
    for(int i=0; i<3; i++){
        if(a[i]>b[i]){ // If Alice has greater point
            al++;
        }else if(a[i]<b[i]){ //If Bob has greater point
            bo++;
        }
    }
    vector<int>v(2); //vector for storing the answer
    v[0]=al;
    v[1]=bo;
    return v; //return the answer stored in vector declared above
}

int main()
{

    vector<int> a(3);

    //Alice points in 3 questions
    for (int i = 0; i < 3; i++) {
        int points;
        cin>>points;
        a[i] = points;
    }


    vector<int> b(3);

    //Bob's points in 3 questions
    for (int i = 0; i < 3; i++) {
        int points;
        cin>>points;
        b[i] = points;
    }

    vector<int> result = compareTriplets(a, b);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i]<<" "; //Printing the results

    }

    return 0;
}
