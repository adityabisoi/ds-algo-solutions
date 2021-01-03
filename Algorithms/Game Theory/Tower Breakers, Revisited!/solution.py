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