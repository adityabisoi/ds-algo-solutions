# input number of strings in the set
N = int(input())
trie = {}
end = object()
# input the strings
for _ in range(N):
    s = input()
    t = trie
    for c in s[:-1]:
        if c in t:
            t = t[c]
        else:
            t[c] = {}
            t = t[c]
        # Print GOOD SET if the set is valid else, output BAD SET 
        # followed by the first string for which the condition fails
        if t is end:
            print("BAD SET")
            print(s)
            exit()
    if s[-1] in t:
        print("BAD SET")
        print(s)
        exit()
    else:
        t[s[-1]] = end
print("GOOD SET")