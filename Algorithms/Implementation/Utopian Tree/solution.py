#!/bin/python

import math
import os
import random
import re
import sys

# Complete the utopianTree function below.
def utopianTree(n):
    height = 1 # Initial height of tree is 1
    
    #For Loop to traverse over n growth cycles. 
    for period in range(1,n+1): 
        
        #For Spring growth cycle , height is doubled.
        if period % 2 == 1 :  
            height = height*2
        
        #For Summer growth cycle , height is increased by one.
        else:
            height = height + 1
    
    #Return the height of Tree after N growth cycles.
    return height

    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(raw_input())

    for t_itr in xrange(t):
        n = int(raw_input())

        result = utopianTree(n)

        fptr.write(str(result) + '\n')

    fptr.close()
