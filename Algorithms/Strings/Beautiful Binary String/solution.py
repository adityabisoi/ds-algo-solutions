#!/bin/python3
# importing modules
import math
import os
import random
import re
import sys

# Complete the beautifulBinaryString function below.
def beautifulBinaryString(b):
    # just need to count the number of occurences of the required substring '010'
    # return this count
    return b.count('010')

# main or driver code
if __name__ == '__main__':
    # opening the output buffer
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    # taking input
    n = int(input())
    # taking string as input
    b = input()
    # getting the result
    result = beautifulBinaryString(b)
    # writing to the output buffer
    fptr.write(str(result) + '\n')
    # closing the output stream / buffer
    fptr.close()
