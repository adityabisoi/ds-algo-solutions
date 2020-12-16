#!/bin/python

# Enter your code here. Read input from STDIN. Print output to STDOUT
T = int(raw_input())
for t in range(T):
    # n is the money available
    # m is the number of wrappers needed for a freebie
    # c is the cost of one chocolate
    n, c, m = [int(s) for s in raw_input().split()]
    candy = n//c
    wrappers = candy
    while wrappers >= m:
        new_candy, wrappers_left = divmod(wrappers, m) #the remainder wrappers that we have by the number of
                                                        # wrappers we can convert to chocolate
        wrappers = wrappers_left + new_candy #wrappers that we have now is left wrappers + new candy's wrappers
        candy += new_candy 
    print candy
      
    