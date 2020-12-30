# input size of array
size = int(input())
# input elements of array
ints = [int(x) for x in input().split()]

# initialize stack 
stack = []
stack.append(ints[0])
max = -1

for i in range(1, size):
    while(len(stack) > 0 and ints[i] <= stack[len(stack)-1]):
        top = stack.pop()
        s = top ^ ints[i]
        if s > max:
            max = s
    if len(stack) > 0 and ints[i] > stack[len(stack)-1]:
        top = stack[len(stack)-1]
        s = top ^ ints[i]
        if s > max:
            max = s
    stack.append(ints[i])
# print the value of maximum possible value 
print(max)