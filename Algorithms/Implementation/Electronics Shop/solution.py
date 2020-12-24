#!/bin/python

import sys


s,n,m = raw_input().strip().split(' ')
s,n,m = [int(s),int(n),int(m)] #s->total amount the person can spend
#n-> no. of keyboards
#m -> no. of pendrives
keyboards = map(int,raw_input().strip().split(' '))  # taking inputs
pendrives = map(int,raw_input().strip().split(' '))

res = -1 #initially the result is -1
for k in keyboards:
    for p in pendrives:
        sm = p + k 
        if sm <= s: #if the sum of pendrive price and keyboard price is less than the amount the person can spend
                       #check condition and print result
            if sm > res:
                res = sm

print res