# Taking the initial values of the pesticide in each of the plants as parameter
# return the number of days after which no plant dies
def solve(ar):
    stack, max_days = [], 0
    for x in ar:
        days = 0
        while stack and x <= stack[-1][0]:
            days = max(days, stack.pop()[1])
        days = days+1 if stack else 0
        max_days = max(days, max_days)
        stack.append([x, days])
    # return the number of days until plants no longer die from pesticide
    print(max_days)
# input size of array and elements of array
N, ar = int(input()), [int(x) for x in input().split()]
#  print the number of days until plants no longer die from pesticide
solve(ar)