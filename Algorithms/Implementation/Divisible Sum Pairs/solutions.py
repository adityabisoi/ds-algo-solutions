#This is a easy questions which can be done by applying bruteforce within the given limit of variables 
#Traverse the array make possible pair of i & j such that j is always greater than i

n, k = map(int,raw_input().split()) #taking n, k as input 
arr = map(int,raw_input().split())  #taking array as input 
count = 0 #variable to count such pairs 
for i in range(0, n):  # 2 nested for loops for comparision of every pair possible 
    for j in range(i+1, n):
        if (arr[i] + arr[j]) % k == 0:  #checking the condition and increasing count if satisfied 
            count += 1
print count  #printing count finally 
