#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <climits>
#include <deque>
#include <iostream>
#include <list>
#include <limits>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <vector>

#define ll long long

#define MIN(a, b) a < b ? a : b
#define MAX(a, b) a > b ? a : b

using namespace std;

int readline(char *str) {
    int i = 0;
    char ch;
    while((ch = getchar()) != '\n') {
        str[i++] = ch;
    }
    str[i] = '\0';
    return i;
}

vector<int> *v;

int main(int argc, char *argv[]) {
    int n, t, lastAns = 0;
    scanf("%d%d", &n, &t);

    v = new vector<int>[n];
    while(t--) {
        int a, x, y;
        scanf("%d%d%d", &a, &x, &y);

        if(a == 1) {
            v[(x ^ lastAns)% n].push_back(y);
        }
        else {
            vector<int> c = v[(x ^ lastAns)% n];
            lastAns = c[y % c.size()];
            cout << lastAns << endl;
        }
    }
    delete []v;
    return 0;
}
#Comments
#This was very confusing wording of the question. For me, the use of curly braces in the example made me think, wait, should seqList be a set? But he said it was a list? Does the word sequence suggest it should be ordered? I guess this question reflects real life, when the client cannot express accurately what they want!
#question is not explained well enough to write code..
#Description
#For this question You just need to break it down into each part.

#There is a dynamic array of sequences.

#There are two types of queries:

#one adds an element to a sequence at a calculated index

#two finds the sequence at a calculated index and prints the value at the calculated subindex.
#From my approach



