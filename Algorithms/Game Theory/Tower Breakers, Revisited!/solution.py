def nim_sum(a,n):
    
    ans = 0
    
    for i in range(n):
        ans = ans^a[i]
        
    return ans

t = int(input())