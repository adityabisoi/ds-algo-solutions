# input size of array
n = int(input())
# input array elements
nums = list(map(int, input().split()))
sum = 0
for num in nums:
    sum += num
print(sum)