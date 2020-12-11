#!/bin/python

import heapq

#no. of cookies and sweeetness required
N, K = map(int, raw_input().split(' '))
#getting the value for sweetness of cookies
cookies = map(int, raw_input().split(' '))
heapq.heapify(cookies)
 
def sweetness_to_k(cookies, K):
    operations = 0
    if not len(cookies):
        return -1
    
    while len(cookies):
        c1 = heapq.heappop(cookies)
        if c1 < K:
            operations +=1
            if len(cookies):
                c2 = heapq.heappop(cookies)
                n = c1 + 2*c2  #formulating the sweetness acc to question
                heapq.heappush(cookies, n)
            else:
                return -1
        else:   
            break 
    return operations

print sweetness_to_k(cookies, K)