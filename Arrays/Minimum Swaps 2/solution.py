# Minimum Swaps function
def minimumSwaps(arr):
    #   length of array
    n = len(arr)
    # parallel array to give
    # index positioning to each element
    arrpos = list(enumerate(arr))

    # Under key, we have a special lambda function which returns the
    # value at index 1 of each tuple
    # the second array is sorted according to increasing order of elements
    arrpos.sort(key = lambda tup : tup[1])

    # initiating counter as false for non traversed elements
    counter = [False]*n

    res = 0         # res stores result
    for i in range(n):
        # if the element has been traversed or
        # the element is at right position then continue
        if counter[i] or arrpos[i][0]==i:
            continue
        # find number of nodes in this cycle and add to result
        j = i
        cs = 0      # cs denotes cycle size
        while not counter[j]:
            counter[j] = True       # element has been traversed
            # move to next element
            j = arrpos[j][0]
            cs += 1

        # adding cs to result for each node
        if cs :
            res += (cs-1)

        return res              # return result



def main():
    n = int(input())                    # Number of elements in the array
    arr = list(map(int,input().split()))    # Single line input
    print(minimumSwaps(arr))

# Code Execution
if __name__ == '__main__':
    main()
