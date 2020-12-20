#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the bomberMan function below.
def bomberMan(n, grid):
    if n in [0, 1]: return grid
    elif n % 2 == 0: return ['O' * len(x) for x in grid]
    else:
        #replace symbols
        grid = [x.replace('O', '2') for x in grid]
        grid = [x.replace('.', '0') for x in grid]
        #split rows into list
        grid = [list(map(int, list(x))) for x in grid]
        
        R = len(grid)
        C = len(grid[0])
        t = 1
        while t < 4 + n % 4:
            t += 1
            #each second check whole grid
            destroyed = [] #for location of cells that will explode
            for r in range(R):
                for c in range(C):
                    #decrease bomb timer (simultaneously with either planting or explosion)
                    if grid[r][c] > 0: grid[r][c] -= 1

                    #plant
                    if t % 2 == 0 and grid[r][c] == 0: grid[r][c] = 3

                    #explode
                    elif grid[r][c] == 0:
                        destroyed.append([r, c])
                        if r < R-1: destroyed.append([r+1, c])
                        if r > 0: destroyed.append([r-1, c])
                        if c < C-1: destroyed.append([r, c+1])
                        if c > 0: destroyed.append([r, c-1])
            if destroyed:
                grid = [[2] * len(x) for x in grid]
                for r, c in destroyed:
                    grid[r][c] = 0
    
        #convert lists to strings
        grid = [''.join(list(map(str, x))) for x in grid]
        #replace symbols
        grid = [x.replace('2', 'O') for x in grid]
        grid = [x.replace('0', '.') for x in grid]
    
        return grid

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    rcn = input().split()

    r = int(rcn[0])

    c = int(rcn[1])

    n = int(rcn[2])

    grid = []

    for _ in range(r):
        grid_item = input()
        grid.append(grid_item)

    result = bomberMan(n, grid)

    fptr.write('\n'.join(result))
    fptr.write('\n')

    fptr.close()