# input number of testcases
test=int(input())
for i in range(test):
    # input the number of predicted prices for WOT
    n=int(input())
    # input array of predicted stock price
    a=list(map(int,input().split()))
    c=0
    i=len(a)-1
    while(i>=0):
        d=a[i]
        l=i
        p=0
        while(a[i]<=d and i>=0):
            p+=a[i]
            i-=1
        c+=(l-i)*a[l]-p
        continue
    # print 'test' lines each containing the maximum profit which can be obtained for the corresponding test case
    print (c)