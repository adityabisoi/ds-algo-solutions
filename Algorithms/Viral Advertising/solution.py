#!/bin/python3

import math
import os
import random
import re
import sys

#the viralAdvertising function returning cumulative 
#number of people who have liked the ad at a given time
def viralAdvertising(n):
    shared =5
    cumulative=0
    for i in range(1,n+1):
        liked = shared//2
        cumulative+=liked
        shared = liked*3
    return cumulative

#main module
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    result = viralAdvertising(n)

    fptr.write(str(result) + '\n')

    fptr.close()