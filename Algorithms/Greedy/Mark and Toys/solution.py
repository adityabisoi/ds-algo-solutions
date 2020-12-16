#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maximumToys function below.
def maximumToys(prices, k):
    sum=0 # total prices of buying toyes
    total=0 # total number of toyes buy

    prices.sort()# sort the prices so that we can take minimum price toys first.

    for i in prices:
        if(i+sum<=k):
            sum=sum+i
            total=total+1
    return total

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    prices = list(map(int, input().rstrip().split()))

    result = maximumToys(prices, k)

    fptr.write(str(result) + '\n')

    fptr.close()
