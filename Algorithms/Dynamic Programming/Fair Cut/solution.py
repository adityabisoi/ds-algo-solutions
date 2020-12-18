#input values are mapped into n and k variables
[n, k] = map(int, input().split())
a = sorted(map(int,input().split()))

#returning -1 when j is looping in range of n 
#for i in range of n is nested loop under the previous loop
T = [[-1 for j in range(n)] for i in range(n)]

for i in range(n):
 
    #if first row then set values equal to zero in T-2D array
    if i == 0: 
        T[i][0] = 0
        T[i][1] = 0
    else:
        
        #assign values after looping in the range of maximum from the input parameters
        for j in range(max(0,k-(n-i-1)), k+1):
            if T[i-1][j] == -1:
                continue
            T[i][j] = T[i-1][j] + (a[i]-a[i-1])*j*(n-i-(k-j))
            T[i][j] += (a[i]-a[i-1]) * (i-j) * (k-j)

        for j in range(max(0,k-(n-i)), k):
            if T[i-1][j] != -1:
                if T[i][j+1] == -1:
                    T[i][j+1] = T[i-1][j] + (a[i]-a[i-1]) * (j*(n-i-(k-j))+(i-j)*(k-j))
                else:
                    T[i][j+1] = min(T[i][j+1], T[i-1][j] + (a[i]-a[i-1])*(j*(n-i-(k-j))+(i-j)*(k-j)))

#single integer denoting the minimum measure of unfairness of some division where Li gets k integers
print (T[n-1][k])

