#!/bin/python3

import sys

# input number of strings
n = int(input().strip())
for a0 in range(n):
    # input the strings
    s = input().strip()
    # print minimum cost of constructing new string
    print(len(set(s)))