#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// Implementation Part
int solveMeFirst(int a, int b) {
 
 // such a easy problem we need to return sum of two numbers only
 return a + b; 
}

// Driver Code
int main() 
{
  int num1, num2;
  int sum;
  cin>>num1>>num2;
  sum = solveMeFirst(num1,num2);
  cout<<sum;
  return 0;
}
