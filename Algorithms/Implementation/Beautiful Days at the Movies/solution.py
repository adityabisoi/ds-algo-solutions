#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the beautifulDays function below.
def beautifulDays(i, j, k):
    # set a count variable initialised to 0   
    count=0
    # run a for loop 
    for i in range(i,j+1):
        # convert the number into string and then reverse 
        rev=str(i)[::-1]
        # convert string back to integer and computer absolute difference
        if(abs(int(rev)-i)%k==0):
            # increment the count variable
            count+=1
    # return the count variable
    return count

# driver code or main function
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ijk = input().split()

    i = int(ijk[0])

    j = int(ijk[1])

    k = int(ijk[2])

    result = beautifulDays(i, j, k)

    fptr.write(str(result) + '\n')

    fptr.close()
