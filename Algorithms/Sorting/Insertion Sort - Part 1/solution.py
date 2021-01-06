# input array size
n = int(input())
# input array elements
d = [int(x) for x in input().split()]
t = d[n-1]
k = n-2

while k >= 0 and t < d[k]:
    d[k+1] = d[k]
    s = str(d)[1:-1].replace(",", "")
    print(s)
    k -= 1
d[k+1] = t
s = str(d)[1:-1].replace(",", "")
# Print the interim and final arrays, each on a new line
print(s)