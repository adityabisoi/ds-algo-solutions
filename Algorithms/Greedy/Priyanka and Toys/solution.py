# required function
def toys(s):
    # sorting array
    s.sort()
    i = 0
    j = 0
    boxc = 0        # index for box array
    box = [[]]
    while i < len(s):
        val = 4+s[j]
        # applying condition
        if s[i] <= val:
            box[boxc].append(s[i])
        else:
            j = i
            # increasing size of box array
            box.append([])
            boxc+=1
        i+=1
    # required return value
    return len(box)

def main():
    # input
    n = int(input())
    num = list(map(int,input().split(' ')))
    # calling function
    print(toys(num))

# Code Execution
if __name__ == '__main__':
    main()
