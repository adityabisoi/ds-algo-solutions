def nim_sum(a,n):
    
    ans = 0
    
    for i in range(n):
        ans = ans^a[i]
        
    return ans

t = int(input())
while(t != 0):
    t -= 1
    
    n = int(input())
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
            