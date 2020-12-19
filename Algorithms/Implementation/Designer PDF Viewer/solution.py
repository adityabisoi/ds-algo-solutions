def designerPdfViewer(h, word):               # Defining a function
    height = []                               # list of height of all the letters in the word
    for letter in word:                       # iterating in word letter by letter
        order = ord(letter) - 97              # matching the order of letter in the given list(h)
        height.append(h[order])               # adding the height of the letter in the list
    maximum = max(height)                     # maximum height in the list will be the length of rectangle
    breadth = len(height)                     # total letters un the word will be the breadth
    area = breadth * maximum                  # calculating area
    return area                               # returning the area


h = list(map(int, input().rstrip().split()))  # prompt user for list of heights
word = input()                                # and word
result = designerPdfViewer(h, word)           # calling the function and passing the values
print(result)                                 # printing the results
