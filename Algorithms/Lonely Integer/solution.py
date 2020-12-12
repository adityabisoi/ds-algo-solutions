#!/bin/python3

import math
import os
import random
import re
import sys



# Code to be written by user 


def lonelyinteger(a):
    
    #converting to list to eliminate the repeated elements.
    b = set(a)
    
    #length of a i.e. number of repeated elements.
    n = len(a)
    
    #if len(a) i.e. if the list has only one element return that element only.
    if n == 1:
        return a[0]
    
    
    #else return result where result is difference between the double of sum of elements in set b and sum of elements in list a 
    return ((sum(b)*2 - sum(a)))


#code snippet given by Hackerrank

if _name_ == '_main_':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    a = list(map(int, input().rstrip().split()))

    result = lonelyinteger(a)

    fptr.write(str(result) + '\n')

    fptr.close()
