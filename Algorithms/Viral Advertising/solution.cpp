#include <algorithm>
#include <bitset>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <vector>
using namespace std;

int n;
long long cumulative = 0; #initializing cumulative variable

int main() {
	cin >> n; #taking input
	int counts = 2; #initializing counts variable with 2
	for (int i = 1; i <= n; i++) { #running a loop to get the values
		cumulative += counts; #updating the cumulative variable
		counts = counts * 3 / 2; #updating counts according to question
	}
	cout << cumulative << endl; #returning value of cumulative variable
	return 0;
}
