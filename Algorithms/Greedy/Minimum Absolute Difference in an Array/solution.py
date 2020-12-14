import math
import os
import random
import re
import sys

n = int(input())
arr = list(map(int, input().rstrip().split()))

def minimumAbsoluteDifference(arr):
    min=abs(arr[-1] - arr[0])
    arr.sort() #We sort the array to make sure that the difference between the adjacent elements is minimal
    for i in range(1,n):
        diff= abs(arr[i]-arr[i-1]) #Now we find the ith absolute difference
        if(min>diff): #Comparing the current difference with the minimum difference and then updating the min with diff if the condition satisfies
            min=diff 
            
    return min

result = minimumAbsoluteDifference(arr)

print(result)
