# input the number of clouds
n=int(input())
# input binary integers describing clouds
a=list(map(int,input().split()))
i=0
c=0
while i!=n-1:
    if i+2<=n-1:
        if a[i+2]!=1:
            i=i+2
        else:
            i=i+1
    else:
        i=i+1
    c=c+1
# print the minimum number of jumps neede to win the game 
print(c)