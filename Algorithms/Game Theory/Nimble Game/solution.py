test = int(input())
for _ in range(test):
    n = int(input())
    ar = list(map(int,input().strip().split()))
    result = []
    for i in range(len(ar)):
        result.append(ar[i]%2)