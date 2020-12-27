# input the number of cities in Goodland and the plants' range constant
n,k = map(int, input().strip().split(' '))
# input the array elements
a = list(map(int, input().strip().split(' ')))
i = k-1
j = i
#Print a single integer denoting the minimum number of plants 
#that must be built so that all of Goodland's cities have electricity
#If this is not possible for the given value of k, print -1
while a[j]!=1 and j>-1:
    j -= 1
    if j==-1:
        print('-1')
        quit()
rep = 1
i = j+2*k-1
while i<n:
    j = i
    while a[j]!=1 and j>i-(2*k-1): j -= 1
    if j==i-(2*k-1):
        print('-1')
        quit()
    i = j+2*k-1
    rep += 1
if j+k-1<n-1:
    j = n-1
    while a[j]!=1 and j>i-(2*k-1): j -= 1
    if j==i-(2*k-1):
        print('-1')
        quit()
    rep += 1
print(rep)
        