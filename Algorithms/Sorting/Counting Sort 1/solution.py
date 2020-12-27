#input number of items in array
N = int(input())
#input array elements
arr = list(map(int, input().split()))

freq = [0]*100

for i in arr:
    freq[i] = freq[i]+1

#output the sorted array
print (' '.join(map(str, freq)))