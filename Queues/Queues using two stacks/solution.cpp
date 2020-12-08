#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <climits>
#include <deque>
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int readline(string str) {
    int i = 0;
    char ch;
    while(ch!= '\n') {
        str[i++] = ch;
    }
    str[i] = '\0';
    return i;
}

stack<int> s1;
stack<int> s2;
int front_val;

//to insert element to queue
void enqueue(int x) {
    while(!s2.empty()) {
        //push the element on top of s2 to s1 and pop it from s2
        s1.push(s2.top());
        s2.pop();
    }
    //the element to be enqueued will be the front value if s1 is empty
    if(s1.empty()) {
        front_val = x;
    }
    //push the element to s1
    s1.push(x);
}

//to delete element from queue
int dequeue() {
    while(!s1.empty()) {
        //push the top element of s1 to s2 and pop it from s1
        s2.push(s1.top());
        s1.pop();
    }
    //store the top of s2 into variable which is the dequed element
    int x = s2.top();
    s2.pop();
    if(!s2.empty()) {
        front_val = s2.top();
    }
    return x;
}

//to get the front value
int front() {
    return front_val;
}

int main(int argc, char *argv[]) {
    int t;
    scanf("%d", &t);
    while(t--) {
        int op;
        scanf("%d", &op);
        switch(op) {
            case 1:
                int x;
                scanf("%d", &x);
                enqueue(x);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                printf("%d\n", front());
                break;
        }

    }

    return 0;
}