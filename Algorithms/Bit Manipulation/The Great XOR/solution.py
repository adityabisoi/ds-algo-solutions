# importing relevant python libraries
import math
import os
import random
import re
import sys

#the theGreatXor function returning an integer representing 
#the number of values satisfying the constraints
def theGreatXor(n):
    m = 1
    c = 0
    while n > 0:
        if (n & 1) == 0:
            c|= m
        m<<= 1
        n>>= 1
    return c

#main module
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        x = int(input())

        result = theGreatXor(x)

        fptr.write(str(result) + '\n')

    fptr.close()
