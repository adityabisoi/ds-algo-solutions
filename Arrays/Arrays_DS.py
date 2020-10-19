input()
arr = list(map(int, input().split()))
x = []
for i in range(len(arr)-1, -1, -1):
    x.append(arr[i])

print(*x)
