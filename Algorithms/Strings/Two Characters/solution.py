n=int(input())
s=list(input())
ans=0
for i in set(s):
    for j in set(s):
        if(j!=i):
            temp=[k for k in s if k==j or k==i]
            f=0
            