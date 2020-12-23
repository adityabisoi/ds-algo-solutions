#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    c = 0                           # count for matching pairs
    ar.sort()
    i = 0
    for j in range(n - 1):
        if i >= n-1:
            break
        if ar[i] in ar[i+1:]:       # checking for the same colour as ith element in further elements
            c += 1                  # if yes, increase the count by 1
            i += 2                  # and skip one index
        else:
            i += 1                  # else move on to the next element
    return c

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = sockMerchant(n, ar)

    fptr.write(str(result) + '\n')

    fptr.close()
