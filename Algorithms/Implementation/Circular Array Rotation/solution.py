n,k,q=input().split()
n,k,q=[int(n),int(k),int(q)]
a=list(map(int, input().split()))
k=k%n
b=a[n-k:]
del a[n-k:]
a=b+a
while q!=0:
    i=int(input())
    print(a[i])
    q-=1