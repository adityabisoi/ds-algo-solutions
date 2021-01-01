#Question Link
#https://practice.geeksforgeeks.org/problems/find-pair-given-difference/0



for _ in range(t):
    L,N = map(int,input().split())
    arr = list(map(int,input().split()))
    arr.sort()
    flag = -1
    i =0
    j = L-1
    for i in range(len(arr)):
        for j in range(i+1,len(arr)):
            if arr[j] - arr[i] == N:
                flag = 1
                break
    print(flag)
