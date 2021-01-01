#Question link
#https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x/0



t=int(input())
for _ in range(t):
    (n,s)=map(int,input().split())
    a=list(map(int,input().split()))
    c=[]
    for i in range(n):
        if a[i]==s:
            c.append(i)
    if len(c)>0:
        x=len(c)
        print(c[0],c[x-1])
    else:
        print(-1)
