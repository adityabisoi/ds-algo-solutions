# importing heap operations
from heapq import heappush, heappop

heaparr = []                #initialising heap array 
progress = set()            #A set for our progress
 
n = int(input())            #taking input

#checking the queries
for i in range(n):
    T = list(map(int, input().split()))
    
    #insertion into the heap and update the progress
    if(T[0]==1):
        heappush(heaparr, T[1]);
        progress.add(T[1])
        
    #deletion 
    elif(T[0]==2):
        progress.discard(T[1])
        
    #printing the minimum element
    else:
        #delete the min element until it is in our progress
        while heaparr[0] not in progress:
            heappop(heaparr)        #pop from the heap
        print(heaparr[0])
