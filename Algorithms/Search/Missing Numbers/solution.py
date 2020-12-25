# input size of first list
n = int(input())
# input elements of first list
A = [int(i) for i in input().split()]
# # input size of second list
m = int(input())
# input elements of second list
B = [int(i) for i in input().split()]
vals = {}
for i in A:
    if i not in vals:
        vals[i] = -1
    else:
        vals[i] -= 1
for i in B:
    if i not in vals:
        vals[i] = 1
    else:
        vals[i] += 1
pos = []
for i in vals:
    if vals[i] > 0:
        pos.append(i)
pos.sort()
for i in pos:
    # missing numbers printed
    print(i,end=' ')