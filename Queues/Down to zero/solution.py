import math

def solve(n):
    memoize=set()           # Initialize set for memoization
    count=0
    q=[]
    q.append((n,count))
    while len(q):
        data,count=q.pop(0)
        if data<=1:
            if data==1:
                count+=1                # Increment count 
            break
        if data-1 not in memoize:
            q.append((data-1,count+1))
            memoize.add(data-1)
        sqr=int(math.sqrt(data))
        for i in range(sqr,1,-1):
            if data%i==0:
                div=max(int(data/i),i)
                if div not in memoize:
                    memoize.add(div)
                    q.append((div,count+1))
    return count                # Return minimum counts
    
if __name__=="__main__":
    for _ in range(int(input())):
        N=int(input())
        print(solve(N))