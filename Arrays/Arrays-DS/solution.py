#!/bin/python3

import math
import os
import random
import re
import sys

# A list L can be reversed using the Slice feature of Python.
# For example, if L = [1,2,3,4,5,6]
# L[0:4:2] means we start with index 0, stop on index 4 with a step of size 2
# So the result will be [1,3,5]
# 
# To reverse a list we start from index = 0 ; goes till last index ; with a step size of -1.
# i.e. L[::-1] is [6,5,4,3,2,1]

def reverseArray(a): # a is the array
    return a[::-1]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = reverseArray(arr)

    fptr.write(' '.join(map(str, res)))
    fptr.write('\n')

    fptr.close()
