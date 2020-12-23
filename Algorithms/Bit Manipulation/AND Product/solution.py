#!/bin/python3

import math
import os
import random
import re
import sys

T = int(input())

for _ in range(T) :
    A,B = (int(_) for _ in input().split())
    i,C = -1,A^B
    while C > 0 :
        C >>= 1
        i += 1
    print(A & (2**32-2**i))
    