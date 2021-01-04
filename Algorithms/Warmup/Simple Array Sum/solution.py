# input size of array
n = int(input())
# input array elements
nums = list(map(int, input().split()))
sum = 0
# Print the sum of the array's elements as a single integer
for num in nums:
    sum += num
print(sum)