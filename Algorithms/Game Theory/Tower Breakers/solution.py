#input number of test cases
test = int(input())
for _ in range(test):
    #input number of towers and height of towers
    n,m = map(int,input().strip().split())
    #if the first player wins, print 1, otherwise, print 2
    if m==1:
        print(2)
    else:
        if n%2==1:
            print(1)
        else:
            print(2)