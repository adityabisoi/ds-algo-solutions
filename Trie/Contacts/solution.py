# input n, number of operations
n = int(input())
dictWords = {}

for iter in range(n):
    # input add/find and name/substring
    (mode,word) = input().split()
    
    # if operation is add
    if mode == "add":
        # for each possible substring of name
        # use dictionary of pair (key = substring, value = count of substring)   
        for i in range(1,len(word)+1):
           
            # update count of substring of name
            if word[:i] in dictWords:
                dictWords[word[:i]] += 1
            else:
                dictWords[word[:i]] = 1
                
    else:
        # for find operation find its key and print it's count
        if word in dictWords:
            print(dictWords[word])
        else:
            # print 0 if key i.e substring not found
            print(0)
  
