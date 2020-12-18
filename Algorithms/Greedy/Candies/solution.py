# input the number of students in class
N = int(input())
a = []
# input the elements of array that is the rating of each student
while N>0:
	a.append(int(input()))
	N -= 1
N = len(a)
left, right, num = [[0 for i in range(N)] for j in range(3)]
p = 1
while p<N:
	if a[p] > a[p-1]:
		left[p] = left[p-1] + 1
	p += 1
p = N-2
while p>=0:
	if a[p] > a[p+1]:
		right[p] = right[p+1] + 1
	p -= 1
p = 0
while p<N:
	num[p] = 1 + max(left[p], right[p])
	p += 1

# minimum number of candies that must be bought
print(sum(num))