#!/bin/python

import sys
#number of buildings input
N = int(input()) 
#height input
h = map(int,sys.stdin.readline().split()) + [0] #Using the readline() instead of input() as also takes input from the user but also reads the escape character.
# Create an empty stack
stack = []
i = 0
#largest/best area initializing w 0
best = 0
while i<=N: #given range of height h from 1 to N
    if len(stack)==0 or h[stack[-1]]<=h[i]: #push height into the stack if the stack is empty or if the top of the stack has lesser height than the current building
        stack.append(i)
        i+=1
    else: 
        p = stack.pop() #pop one building at a time 
        #and then calculating the area, for example: pop building 5, area now is 5*1=5 
        # then pop building 4, the area now becomes 4*2=8, as there are now two building popped/or the area of two building have been taken into consideration
        #then pop building 3, area now is 3*3=9
        A = h[p]*(i-stack[-1]-1) if len(stack)>0 else h[p]*i 
        best = max(best,A) #the area with max value will be displayed as output
print best
