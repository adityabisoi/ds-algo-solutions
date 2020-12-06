This code is from the problem : https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem.
In the problem we have to write a function to determine wheather a cycle exists in a linked list or not.
This function returns true if cycle exists else returns false.
Function Description:
There are two pointers which initially pointing where head is pointing.These two pointers to the node will traverse through the node.
One of them will go through every node and the other one will skip each alternative node.
Thus if cycle exists then in some step they are going to point at a same node.When this happens we return true i.e. cycle exists.
If cycle doesn,t exist then the fast moving node will point at nullptr or the tail element of the list.If this happens we return
False i.e. cycle doesn't exists.
