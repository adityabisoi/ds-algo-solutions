#!/bin/python3

import math
import os
import random
import re
import sys

# Code to completed by User
def maximizingXor(l, r):
    
    return max([i^j for i in range(l, r+1) for j in range(i, r+1)])
    
#Code snippet given by Hackerrank  
if _name_ == '_main_':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    l = int(input())

    r = int(input())

    result = maximizingXor(l, r)

    fptr.write(str(result) + '\n')

    fptr.close()
