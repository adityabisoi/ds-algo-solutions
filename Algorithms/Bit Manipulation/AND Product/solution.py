#!/bin/python3

import math
import os
import random
import re
import sys

T = int(input())

for _ in range(T) :
    A,B = (int(_) for _ in input().split())
    i,C = -1,A^B #C is the bits where A and B differ
    while C > 0 :
        C >>= 1     # mask out all lower bits than the max bit of C
                    
        i += 1 #increase the value of i (2's power)
     # remove those bits
    print(A & (2**32-2**i))
    