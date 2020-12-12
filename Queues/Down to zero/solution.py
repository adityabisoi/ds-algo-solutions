import math # importing math functions

def solve(n):   # main logic
    memoize=set() #  return values are the same for same inputs every time
    count=0
    q=[]
    q.append((n,count))  # adding values to the end of list
    while len(q):    # checking the condition
        data,count=q.pop(0) # removes and returns last value from the list or the given index value
        if data<=1:  # base case
            if data==1:
                count+=1  # incrementing the count value by 1
            break
        if data-1 not in memoize:  # second operation
            q.append((data-1,count+1))  # returns count of how many times a given object occurs in list by adding to end
            memoize.add(data-1)
        sqr=int(math.sqrt(data))  # this function returns the square root of a number
        for i in range(sqr,1,-1):   # first operation
            if data%i==0:  # to check if the data assigned is equal to zero or not
                div=max(int(data/i),i)  # Function to return the largest number that divides the maximum elements from the given array
                if div not in memoize:
                    memoize.add(div)
                    q.append((div,count+1)) # adding the count that divides the max element at the end of list
    return count
    
if __name__=="__main__":
    for _ in range(int(input())):
        N=int(input())
        print(solve(N))   # print output