/*we make an array days, which stores the no of days for which the 
ith plant lives, the max value in this array is the day after which
no plant dies
To make the days array, we need to understand that every plant to the right
of a plant will get destroyed untill there is a plant with less pesticides
so we'll keep the min element till the current element on top of the stack 
and update days array accordingly*/

#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;

    int* p = new int[n];
    for(int i=0;i<n;i++)
        cin>>p[i];

    int* days = new int[n]();
    int min = p[0];
    int max = 0;
    stack<int> s;

    s.push(0); //pushing the index of first element 

    for(int i=1;i<n;i++)
    {
        if(p[i] > p[i-1])
            days[i] = 1;  //setting the day[i] to 1 in case it's initial left plant has less pesticide 
        
        min = min < p[i]?min:p[i]; //comparing and updating min if p[i] is smaller 

        while(!s.empty() && p[s.top()] >= p[i]) //updating days and stack if the current element has less pesticide than the top element 
        {
            if(p[i] > min)
                days[i] = days[i] > days[s.top()] + 1?days[i]:days[s.top()] + 1;
                //if the plant isn't dead by the day the top plant dies, it'll die the next day
            s.pop(); //popping the top element so that the min element remains on top finally 
        }  

        max = max>days[i]?max:days[i]; //updating max days in case day[i] is the largest 
        s.push(i); //pushing the ith element in stack 
    }

    cout<<max<<endl;
}
