#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the bigSorting function below.
def bigSorting(unsorted):
    #converting string to integer and inserting in a list
    c=[int(integer) for integer in unsorted] 
    c=sorted(c)   # sorting using sorted function
    strings = [str(integer) for integer in c]  # converting back to string
    return(strings) 

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())   # input the numbers

    unsorted = []

    for _ in range(n):
        unsorted_item = input()
        unsorted.append(unsorted_item)

    result = bigSorting(unsorted)

    fptr.write('\n'.join(result))
    fptr.write('\n')

    fptr.close()
