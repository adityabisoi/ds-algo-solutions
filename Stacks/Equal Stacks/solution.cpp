#include<bits/stdc++.h> //This header file imports everything we need
using namespace std ;

vector<int> temp ;
void get_stack(stack<int>& h) // will give us the stack in a required way
{
	reverse(temp.begin(), temp.end()) ;
	for(auto ele : temp)
	{
		h.push(ele) ;
	}
}
int main()
{
    int n1, n2, n3 ;
	cin >> n1 >> n2 >> n3 ;
	stack<int> h1, h2, h3 ; // Our Stack of Cylinders
	long long sum1 = 0 , sum2 = 0, sum3 = 0 ; // will hold the sum of the respective cyclinder 
	for(int i=0 ; i<n1 ; i++) // Taking the first cylinder as input
	{
		int x ;
		cin >> x ;
		sum1 += x ;
		temp.push_back(x) ;
	}
	get_stack(h1) ;
	temp.clear();
	for(int i=0 ; i<n2 ; i++) // Taking the second cyclinder as input
	{
		int x ;
		cin >> x ;
		sum2 += x ;
		temp.push_back(x) ;
	}
	get_stack(h2) ;
	temp.clear() ;
	for(int i=0 ; i<n3 ; i++) // Taking the third cyclinder as input
	{
		int x ;
		cin >> x ;
		sum3 += x ;
		temp.push_back(x) ;
	}
	get_stack(h3) ;
	
	while((sum1 != sum2) || (sum2 != sum3)) // we will loop unless all of three sum becomes equal
	{
		if((sum1 >= sum2) && (sum1 >= sum3))
		{
			sum1 -= h1.top() ;
			h1.pop() ;
		}
		else if((sum2 >= sum1) && (sum2 >= sum3))
		{
			sum2 -= h2.top() ;
			h2.pop() ;
		}
		else if((sum3 >= sum1) && (sum3 >= sum2))
		{
			sum3 -= h3.top() ;
			h3.pop() ;
		}
	}
	cout << sum1 ; // printing any of the sums as all are equal now
}
