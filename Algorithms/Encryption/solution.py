#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the encryption function below.
def encryption(s):
    #length L of string
    L = len(s)

    #final outup string
    fin_str=""
    
    #initializing rows and columns
    row = 0
    col = 0

    #removing all spaces from the string
    s = s.replace(" ", "")
    
    #number of rows
    row = math.floor(math.sqrt(L))
    
    #number of columns
    col = math.ceil(math.sqrt(L))
    
    #ensuring rows x columns >=L
    if(row * col < L):
        row += 1
        
     
    encrypted_grid = [[None for _ in range(col)] for _ in range(row)]

    #Forming the grid
    for i in range(row):
        
        j=0
        for j in range(col):
            if((col*i+j)<L):
                encrypted_grid[i][j] = s[(col * i)+j]


    #forming fin_str by cllecting all the characters along a column first
    for i in range(col):
        
        for j in range(row):
            if(encrypted_grid[j][i]!= None):
                fin_str+=encrypted_grid[j][i]
        fin_str+=" "                     #adding a space after each encrypted word
    
    
    return fin_str
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = encryption(s)

    fptr.write(result + '\n')

    fptr.close()

