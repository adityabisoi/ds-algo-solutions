test=int(input())
for i in range(test):
    n=int(input())
    a=list(map(int,input().split()))
    c=0
    i=len(a)-1
    while(i>=0):
        d=a[i]
        l=i
        p=0
        while(a[i]<=d and i>=0):
            p+=a[i]
            i-=1
        c+=(l-i)*a[l]-p
        continue
    print (c)