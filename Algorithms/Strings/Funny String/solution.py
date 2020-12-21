#!/bin/python

import math
import os
import random
import re
import sys

if __name__ == '__main__':
   cases = int(input())
   for caseNo in range(cases):
    s = raw_input()
    #reverse string
    rs = s[::-1]
    n = len(s)
    #take the difference of ascii values
    for i in range(1, n):
        d1 = abs(ord(s[i]) - ord(s[i - 1]))
        d2 = abs(ord(rs[i]) - ord(rs[i - 1]))
        #if the difference at any point isn't equal string is not funny
        if d1 != d2:
            print("Not Funny")
            break
    else:
        print("Funny")
