#!/bin/python

import heapq
"""                                                                                              
N, K = (6,7)
cookies = [1,2,3,9,10,12]
"""
N, K = map(int, raw_input().split(' '))
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
                n = c1 + 2*c2
                heapq.heappush(cookies, n)
            else:
                return -1
        else:   
            break 
    return operations

print sweetness_to_k(cookies, K)