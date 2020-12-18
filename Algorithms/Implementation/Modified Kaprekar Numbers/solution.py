def kaprekar_number(p, q):             # Function to accept range
    outputs = []                       # an empty list to store all kaprekar value
    for i in range(p, q+1):            # For loop to iterate in the given range
        length = len(str(i))           # *No. of digits in the number
        square = i**2                  # square of the digit
        right = square % (10**length)  # right digit will be the remainder of square divided by 10 to the power length*
        left = square // (10**length)  # eg 45^2=2025 right=2025%(10^2) = 25  and left is = 20
        if (right + left) == i:        # summation of digits should be equal the original digit(i)
            outputs.append(i)          # adding the desired digit in the list
        else:                          # if condition is not satisfied
            continue                   # continue
    return outputs                     # return the result


p = int(input())                       # lower range
q = int(input())                       # upper range
result = kaprekar_number(p, q)         # calling the function and storing its return value in result
if len(result) == 0:                     # if no there is no such digit
    print("INVALID RANGE")             # print invalid
else:
    for i in result:                   # for loop to
        print(i, end=' ')              # print all the values in result
