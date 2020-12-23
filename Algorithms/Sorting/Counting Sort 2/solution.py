# input the length of array
n = int(input())
# input the elements of array
ar = [int(x) for x in input().strip().split(' ')]

c = [0]*100
for a in ar :
    c[a] += 1
    
s = ''

# print the sorted list as a single line of space-separated elements
for x in range(0,100) :
    for i in range(0,c[x]) :
        s += ' ' + str(x)
        
print(s[1:])
    