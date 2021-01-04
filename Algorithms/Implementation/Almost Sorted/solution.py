# input array size
input()
# input array elements
array = [int(x) for x in input().split(" ")]
# store the sorted array
sorted_array = sorted(array)
# If the array is already sorted, output yes on the first line
if array == sorted_array:
    print("yes")
# If you can sort this array using one single operation out of the two permitted operations
# then output yes on the first line and then do as given in the instructions
else:    
    wrong = []
    for i, (a, b) in enumerate(zip(array, sorted_array)):
        if a != b:
            wrong.append(i)
        if len(wrong) > 2:
            break
    if len(wrong) == 2:
        print("yes")
        print("swap", wrong[0]+1, wrong[1]+1)
    else:           
        index = sorted_array.index(array[wrong[0]])+1
        if sorted_array[wrong[0]:index] == list(reversed(array[wrong[0]:index])):
            print("yes")
            print("reverse", wrong[0]+1, index)
        # If you cannot sort the array either way print no on the first line
        else:
            print("no")