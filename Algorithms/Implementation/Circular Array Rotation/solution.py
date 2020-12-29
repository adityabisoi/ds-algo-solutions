# input the number of elements in the integer array, the rotation count and the number of queries
n,k,q=input().split()
n,k,q=[int(n),int(k),int(q)]
# input array to rotate
a=list(map(int, input().split()))
k=k%n
b=a[n-k:]
del a[n-k:]
a=b+a
while q!=0:
    # print the values in the rotated array as requested 
    i=int(input())
    print(a[i])
    q-=1