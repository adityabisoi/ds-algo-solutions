#!/usr/bin/env python3

# main module
if __name__ == "__main__":
    # input number and queries
    n, q = [int(x) for x in input().strip().split()]
    # input n integer sequence
    arr = [int(x) for x in input().strip().split()]
    
    for _ in range(q):
        # input integer of each query
        d = int(input().strip())
        maxes = []
        was_first = False
        
        # print the answer to each query
        for i in range(n - d + 1):
            if i == 0 or was_first == True:
               
                maxes.append(max(arr[i:i+d]))
            else:
                
                maxes.append(max(maxes[-1], arr[i+d-1]))
                
            if maxes[-1] == arr[i]:
                was_first = True
            else:
                was_first = False
            
        print(min(maxes))