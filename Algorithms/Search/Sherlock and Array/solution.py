def check(array):
    right = sum(array)
    left = 0
    for i in range(len(array)):
        right -= array[i]
        if left == right:
            return 'YES'
        left += array[i]
    return 'NO'
# input the number of test cases
cases = int(input())

for i in range(cases):
    # input size of array
    length = int(input())
    # input elements of array
    nums = list(map(int, input().split()))
    #  determine whether there is an element that meets the criteria and print 'YES' or 'NO' accordingly
    ans = check(nums)
    print(ans)