/*
In this question we divide the already entered elements into 2 halves 
the elements in the half with smaller elemenrs go into a max heap 
the elememts in the half with bigger elemenrs go in min heap 
If there are even no of elements we use biggest element of smaller half and
smaller element of bigger half to compute the median
In case of odd no of elements we keep 1 extra element in the max heap or min heap
and use the heap with more elements to calculate median 
*/
#include<bits/stdc++.h>
using namespace std;

priority_queue<int, vector<int>, greater <int> > min_heap; //making a min heap 
priority_queue<int> max_heap; //making a max heap

int absh(int x){   //function to return absolute value of an int
    if(x>0) return x;
    else return (-1*x);
}

void add(int a) //function to add a number 
{
    if( max_heap.size() && a >= max_heap.top()) //if the number is bigger than the current median 
        min_heap.push(a);                       //add in the min heap 
    else
        max_heap.push(a);                       // otherwise max heap 

    if(absh(max_heap.size() - min_heap.size()) > 1) //if the difference between the number of elements 
    {                                               //larger than 1 adjust elements within the heaps to make it 0
        if(max_heap.size() > min_heap.size())  //if max heap has more elements transfer one to min heap 
        {
            int temp = max_heap.top();
            max_heap.pop();
            min_heap.push(temp);
        }
        else                                    //if min heap has more elements transfer it to max heap
        {
            int temp = min_heap.top();
            min_heap.pop();
            max_heap.push(temp);
        }
    }
}

double get_median()  //function to return median with current elements 
{
    int total = min_heap.size() + max_heap.size();
    double ret;
    if(total%2 == 1)        //check if the no of elements is odd, if it is odd we'll have a unique median 
    {
        if(max_heap.size() > min_heap.size()) //checking which of the 2 heaps has the median
            ret = max_heap.top(); 
        else
            ret = min_heap.top();
    }
    else                  //if it is even we have to take the mean of 2 central elements 
    {
        ret = 0;
        if(max_heap.empty() == false)
            ret += max_heap.top();  //adding 1st central element 
        if(min_heap.empty() == false)
            ret += min_heap.top();  //adding 2nd central element 
        ret/=2; // taking mean of both 
    }
    return ret;
}

int main()
{
    cout << setprecision(1) << fixed;
    int n, a;
    cin >> n;
    for(int i = 1; i<=n; i++)
    {
        cin >> a;
        add(a);
        cout << get_median() << endl;
    }
}
