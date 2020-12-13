#include<bits/stdc++.h> //This header file imports everything we need
using namespace std ;

int main()
{
	/*In this problem we will not only store the value but also the max value from last to that paricular value*/
	
	stack <pair<int,int> > stk; // We use pair to store {new_element,new_max} 
	int N ;
	cin >> N ;
	for(int i=1; i<=N; i++)
	{
		int option ;
		cin >> option ;
		if(option == 1)
		{
			int new_element ;
			cin >> new_element ;
			int new_max = stk.empty() ? new_element : max(new_element,stk.top().second) ;
			stk.push({new_element, new_max}) ;
		}
		else if(option == 2)
		{
			stk.pop() ;
		}
		else
		{
			cout << stk.top().second << "\n" ; // Printing the max element
		}
	}
}
