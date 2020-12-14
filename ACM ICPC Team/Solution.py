from itertools import combinations # importing itertools function from combinations
n,k = map(int,input().split()) # taking input as n,k as lists and then separating the characters
teams = [list(map(int,list(input()))) for i in range(n)] # converting list of strings to int using map() 
sums = [sum([x[0] or x[1] for x in list(zip(*i))]) for i in combinations(teams,2)] # using naive method to perform conversion 
# Iterate through every sum lying between the extremities and count the maximum number of pairs we can obtain for each of these sums.
print(max(sums),sums.count(max(sums)),sep='\n') # Print the maximum count among all such pairs obtained to be giving the same summations.