#!/bin/python

import math
import os
import random
import re
import sys

#Taking input the number of element in sequence.
n = int(raw_input())

#Taking input the elements in sequence.
p = map(int, raw_input().split())

#For Loop to traverse the elements in sequence.   
for i in range(1,n+1):
    x = p.index(i)+1
    y = p.index(x)+1
    print (y) 
    
    #The value x gives the position of i in the sequence.
    #The value y gives the position of x in the sequence.
    
    
    #Consider an example:
    #Input : 4 3 5 1 2
     
    #Iteration 1:
    # x = p.index(1) + 1 = 4
    # y = p.index(4) + 1 = 1
    
    #Iteration 2:
    # x = p.index(2) + 1 = 5
    # y = p.index(5) + 1 = 3 
    
    #Iteration 3:
    # x = p.index(3) + 1 = 2
    # y = p.index(2) + 1 = 5
    
    #Iteration 4:
    # x = p.index(4) + 1 = 1
    # y = p.index(1) + 1 = 4
    
    #Iteration 5:
    # x = p.index(5) + 1 = 3 
    # y = p.index(3) + 1 = 2 
    
    #OUTPUT : 1 3 5 4 2
    
    
