#!/bin/python

import math
import os
import random
import re
import sys

#
# Complete the 'dynamicArray' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY queries
#

def dynamicArray(n, queries):
    a=[]   
    b=[]   ##the list to be returned
    lastAnswer = 0
    a=[[] for x in range(n)] #Creating the 2D List consisting of n empty lists 
    for i in range(len(queries)):   #implementing just as as said in the question
        x =(queries[i][1])
        x=(x^lastAnswer)%n
        y=(queries[i][2])
        if queries[i][0]==1 :
            a[x].append(y)
        if queries[i][0]==2 :
            z=len(a[x])
            lastAnswer=a[x][y%z]
            b.append(lastAnswer)

    return b
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = raw_input().rstrip().split()

    n = int(first_multiple_input[0])

    q = int(first_multiple_input[1])

    queries = []

    for _ in xrange(q):
        queries.append(map(int, raw_input().rstrip().split()))

    result = dynamicArray(n, queries)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
