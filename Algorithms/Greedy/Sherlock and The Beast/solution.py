#!/usr/bin/env python

import sys

# driver function
if __name__ == '__main__':
    # input number of test cases
    T = int(sys.stdin.readline())
    
    for _ in range(T):
        # input the number of digits in the number to create
        N = int(sys.stdin.readline())
        
        # Print the decent number for the given length, or -1
        # if a decent number of that length cannot be formed
        if N < 3:
            print(-1)
        else:
            k = N - (N % 3)
            
            if k < N:
                while k > 0 and (N - k) % 5 > 0:
                    k -= 3
            
            if (N - k) % 5 == 0:
                print(('5' * k) + ('3' * (N - k)))
            else:
                print(-1)