# Taking input
n1, n2, n3 = map(input().split())

# Taking input for height of stacks and splitting them
Height1 = map(input().split())[::-1]
Height2 = map(input().split())[::-1]
Height3 = map(input().split())[::-1]

# Calculating sum of height of stacks
sum_height1 = sum(Height1)
sum_height2 = sum(Height2)
sum_height3 = sum(Height3)

# Comparing the three stacks for equality 
while not (sum_height1 == sum_height2 and sum_height2 == sum_height3):
    if sum_height1 > sum_height2 or sum_height1 > sum_height3:
        temp = Height1.pop()
        sum_height1 -= temp

    if sum_height2 > sum_height1 or sum_height2 > sum_height3:
        temp = Height2.pop()
        sum_height2 -= temp

    if sum_height3 > sum_height1 or sum_height3 > sum_height2:
        temp = Height3.pop()
        sum_height3 -= temp
        
# Printing the height where all three stacks are equalised
print sum_height1


# Input
# 5 3 4
# 3 2 1 1 1 
# 4 3 2
# 1 1 4 1
# Output
# 5
