import sys
f=sys.stdin
T=int(f.readline())
while T:
    # input size of arrays A and B
    N,K=map(int, f.readline().split())
    # input elements of array A
    A=list(map(int, f.readline().split()))
    # input elements of array B
    B=list(map(int, f.readline().split()))
    # sort array A
    A.sort()
    # sort array B
    B.sort()
    B.reverse()
    flag=0
    # for each query, print YES on a new line if valid permutations exist, 
    # Otherwise, print NO
    for i in range(len(A)):
        if A[i]+B[i] >=K:
            flag+=1
    if flag==i+1:
        print("YES")
    else:
        print("NO")
    T-=1