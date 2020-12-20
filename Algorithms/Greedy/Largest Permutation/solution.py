#!/bin/python3

import math
import os
import random
import re
import sys


def largestPermutation(k, arr):
    a = dict(enumerate(arr)) #the array consists first n natural numbers 
    #means if n=5 the array will have 5 elements from 1 to 5 (e.g. [4,2,3,5,1]) if n=8 then 1 to 8 no duplicate
    b = {v:k for k,v in a.items()} 
    l = len(arr)
    for i in range(l): #loop through the array
        if k and a[i]!=l-i: #check if current array element is smaller than k
            x = a[i]
            y = b[l-i]
            #swap values as well as indexes in index array
            a[i] = l-i
            a[y] = x
            b[x] = y
            k-=1 #reduce the value of k by 1
        yield a[i] #if you have swaped k times then break out of loop
n,k = map(int,input().split())
arr = list(map(int,input().split()))
print(*largestPermutation(k, arr))