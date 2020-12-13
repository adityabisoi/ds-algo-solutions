#return an integer that represents the results of the calculations
for _ in range(int(input())):
    N = int(input())
    A = tuple(map(int,input().split()))
    X = 0
    for i, x in enumerate(A):
        if ((i+1) * (N-i)) % 2 == 1:
            X ^= x
    print(X)
