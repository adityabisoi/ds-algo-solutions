import math

def solve(n):   # main logic
    memoize=set()
    count=0
    q=[]
    q.append((n,count))
    while len(q):
        data,count=q.pop(0)
        if data<=1:  # base case
            if data==1:
                count+=1
            break
        if data-1 not in memoize:  # second operation
            q.append((data-1,count+1))
            memoize.add(data-1)
        sqr=int(math.sqrt(data))
        for i in range(sqr,1,-1):   # first operation
            if data%i==0:
                div=max(int(data/i),i)
                if div not in memoize:
                    memoize.add(div)
                    q.append((div,count+1))
    return count
    
if __name__=="__main__":
    for _ in range(int(input())):
        N=int(input())
        print(solve(N))   # print output