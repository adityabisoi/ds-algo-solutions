#!/bin/python

import math
import os
import random
import re
import sys

# Complete the surfaceArea function below.
def surfaceArea(A):
    a = 0 # surface area 
    n = [[-1, 0], [0, 1], [1, 0], [0, -1]] # immediate neighbours

    for x in range(H):
        for y in range(W):
            i = A[x][y] # chosing the element
            a += 2 # add base and area of the element
            for dx, dy in n: # looping through immediate neighbours
                try:
                    if -1 in [x+dx, y+dy]:
                        raise IndexError # raise error if index reaches -1
                    add = i - A[x+dx][y+dy] # get area of the corresponding side by subtracting from the neighbour
                    if add > 0:
                        a += add # add area corresponding to the side
                except IndexError:
                    a += i # add whole area of the corresponding side
    return a # return area

    # auto generated code by hackerrank to take input
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    HW = raw_input().split()

    H = int(HW[0])

    W = int(HW[1])

    A = []

    for _ in xrange(H):
        A.append(map(int, raw_input().rstrip().split()))

    result = surfaceArea(A)

    fptr.write(str(result) + '\n')

    fptr.close()
