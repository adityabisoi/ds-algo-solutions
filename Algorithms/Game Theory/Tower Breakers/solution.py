test = int(input())
for _ in range(test):
    n,m = map(int,input().strip().split())
    if m==1:
        print(2)
    else:
        if n%2==1:
            print(1)
        else:
            print(2)