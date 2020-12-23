size = int(input())
array = input().split(" ")
arr = ['None'] * size
for i in range(size):
    arr[i] = int(array[i])
i = 1   
while i < size:
    tmp = arr[i]
    j = i - 1
    while arr[j] > tmp and j > -1:
        arr[j+1] = arr[j]       
        j = j - 1 
    arr[j+1] = tmp
    for k in range(size):
        print(arr[k],end = " ")
    print()    
    i = i + 1