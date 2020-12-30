def solve(ar):
    stack, max_days = [], 0
    for x in ar:
        days = 0
        while stack and x <= stack[-1][0]:
            days = max(days, stack.pop()[1])
        days = days+1 if stack else 0
        max_days = max(days, max_days)
        stack.append([x, days])
    print(max_days)

N, ar = int(input()), [int(x) for x in input().split()]
solve(ar)