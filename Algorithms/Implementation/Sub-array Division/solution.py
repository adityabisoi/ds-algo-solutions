#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the birthday function below.
def birthday(squares, d, m): 
    count = 0    

    #go till length of bar-bithday month
    for i in range(0,len(squares)+1-m):
        #if sum of m squares is equal to d increament the count
        if sum(squares[i:i+m]) == d:
            count+=1
            #return the count
    return count
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    s = list(map(int, input().rstrip().split()))

    dm = input().rstrip().split()

    d = int(dm[0])

    m = int(dm[1])

    result = birthday(s, d, m)

    fptr.write(str(result) + '\n')

    fptr.close()
