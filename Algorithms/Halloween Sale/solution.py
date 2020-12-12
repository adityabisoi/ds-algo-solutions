#!/bin/python

import sys

def howManyGames(p, d, m, s):
    # Return the number of games you can buy
    total = 0
    next_p = p
    
    while (s >= 0):
        s -= next_p #keep on decreasing the price from s (Total amout that we can spend)
        next_p = max(m, next_p-d)  #decreasing the price p by d in each iteration until it reaches price m
        total += 1
    return total-1
    
    
if __name__ == "__main__":
    p, d, m, s = raw_input().strip().split(' ')
    p, d, m, s = [int(p), int(d), int(m), int(s)]
    answer = howManyGames(p, d, m, s)
    print answer
