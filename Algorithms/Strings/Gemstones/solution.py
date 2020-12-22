#!/bin/python

import math
import os
import random
import re
import sys

# Complete the gemstones function below.
def gemstones(arr):
    gem=set(arr[0])
    l=len(arr)
    if(l==1):    
        return len(gem)
    for i in range(1,l):
        #only the minerals common in all are gemstones
        #so we find the intersection and return the length of intersection array
        gem=gem.intersection(arr[i])
    return len(gem)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(raw_input())

    arr = []

    for _ in xrange(n):
        arr_item = raw_input()
        arr.append(arr_item)

    result = gemstones(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
