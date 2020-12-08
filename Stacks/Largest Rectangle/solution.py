#!/bin/python

import sys
N = int(input())
h = map(int,sys.stdin.readline().split()) + [0]

stack = []
i = 0
best = 0
while i<=N:
    if len(stack)==0 or h[stack[-1]]<=h[i]:
        stack.append(i)
        i+=1
    else:
        p = stack.pop()
        A = h[p]*(i-stack[-1]-1) if len(stack)>0 else h[p]*i
        best = max(best,A)
print best