#!/bin/python

import math
import os
import random
import re
import sys

def LCS(A,B):
    n = len(A)
    m = len(B)

    # suffixes[i][j] will be LCS(A[:i],B[:j])
    #build L[m+1][n+1] in bottom up fashion 
    #L[i][j] contains length of LCS of X[0..i-1] 
    suffixes = [[ [] for i in xrange(m+1)] for j in xrange(n+1)]

    for i in xrange(1,n+1):
        for j in xrange(1,m+1):
            if A[i-1]==B[j-1]:
                # LCS(i,j) is LCS(i-1,j-1) plus this last number
                suffixes[i][j] = suffixes[i-1][j-1] + [A[i-1]]
            else:
                # LCS(i,j) is the longer between LCS(i-1,j) and LCS(i,j-1)
                l1 = suffixes[i-1][j]
                l2 = suffixes[i][j-1]
                if len(l1) >= len(l2):
                    suffixes[i][j] = l1
                else:
                    suffixes[i][j] = l2
    # suffixes[m][n] contains the length of LCS of A[0..n-1] & B[0..m-1]                
    return suffixes[n][m]

# we don't need the sizes n and m, but let's store them anyway
[n,m] = map(int, raw_input().split())
# read the two lists
A = map(int, raw_input().split())
B = map(int, raw_input().split())

C = LCS(A,B)
#print C in the format required
print " ".join(map(str,C))