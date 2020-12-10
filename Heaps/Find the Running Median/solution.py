#!/bin/python

import heapq

minHeap = []
maxHeap = []

N = int(raw_input()) #no. of integers in data stream
first = float(raw_input())
heapq.heappush(minHeap, first)
print first
for i in xrange(2,N+1): #adding ith integer
    cur = float(raw_input())
    if cur > minHeap[0]:
        heapq.heappush(minHeap, cur) #entering elements in minHeap only if element entered is greater that current
    else:
        heapq.heappush(maxHeap, -cur) #entering elements in maxHeap if not so, -cur so as to find the max element at root
        #checking balance of heaps
    if len(maxHeap) - len(minHeap) > 1:
        maxs = heapq.heappop(maxHeap)
        heapq.heappush(minHeap, -maxs) #pushing the maxs element popped from maxheap into min heap
    elif len(minHeap) - len(maxHeap) > 1:
        mins = heapq.heappop(minHeap)
        heapq.heappush(maxHeap, -mins)
    
    #print "min" of minHeap
    #print "max"of maxHeap
    if i % 2 == 1: #if set contains odd number of elements
        if len(minHeap) > len(maxHeap): 
            print minHeap[0] 
        else:
            print -maxHeap[0] 
    else:
        print (minHeap[0] - maxHeap[0]) / 2 
    