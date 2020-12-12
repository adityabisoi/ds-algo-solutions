n,d=map(int,input().split())
arr=list(map(int,input().split()))

num=d%n     # Remove excess number of rotations

for _ in range(num):    # Do operations in range num
    x=arr.pop(0)
    arr.append(x)

print(*arr) # Unpack the list