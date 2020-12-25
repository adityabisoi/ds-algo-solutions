#!/bin/python

import math
import os
import random
import re
import sys

# Complete the unboundedKnapsack function below.

T = int(raw_input())   # Input Variable for number of entries

def multisum(k, C):   
    D = [False for _ in range(k+1)]   # Create a list of length k+1 which contain False
    D[0] = True                       
    for i in range(1,k+1):
        D[i] = any([D[i-c] for c in C if i - c >= 0]) 
    for i in reversed(range(k+1)):
        if D[i]:                   # if content is true then return i
            return i
    return None

# Loop for taking all the inputs
for i in range(T):  
    n, k = map(int, raw_input().strip().split(' '))
    C = map(int, raw_input().strip().split(' '))
    print multisum(k,C)
