#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the breakingRecords function below.

def breakingRecords(scores):
    r = [0,0]                       # record breaks list - first element for highest score & second for lowest score
                                    # both initially set to 0
    maxm = scores[0]
    minm = scores[0]
    for i in range(len(scores)):
        if scores[i]>maxm:
            maxm = scores[i]        # updating the greatest score
            r[0]+=1                 # incrementing by 1
        if scores[i]<minm:
            minm = scores[i]        # updating the lowest score
            r[1]+=1                 # incrementing by 1
    return r

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    scores = list(map(int, input().rstrip().split()))

    result = breakingRecords(scores)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
