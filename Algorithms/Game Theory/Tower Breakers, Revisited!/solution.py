def nim_sum(a,n):
    
    ans = 0
    
    for i in range(n):
        ans = ans^a[i]
        
    return ans
# input number of testcases
t = int(input())
while(t != 0):
    t -= 1
    # input number of towers
    n = int(input())
    # input height of each tower
    a= [int(i) for i in input().split()]
    
    b = [0 for i in range(n)]
    for i in range(n):
        if(a[i] == 1):
            b[i] = 0
        else:
            b[i] = 0
            
            j = 2
            
            root = int(pow(a[i],0.5))
            while(a[i] != 1 and j<=root):
                if(a[i]%j == 0):
                    while(a[i]%j == 0):
                        b[i] += 1
                        a[i] = a[i]//j
                    
                j += 1
                
            if(a[i] != 1):
                b[i] += 1

    ans = nim_sum(b, n)
    # for each test case print an integer denoting to a winner
    if(ans != 0):
        print("1")
    else:
        print("2")