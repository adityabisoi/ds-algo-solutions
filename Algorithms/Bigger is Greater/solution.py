# Algorithm Link
# https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order


def biggerIsGreater(w):
    arr = list(w)
    # Find non-increasing suffix
    i = len(arr) - 1
    while i > 0 and arr[i - 1] >= arr[i]:
        i -= 1
    if i <= 0:
        return "no answer"
    
    # Find successor to pivot
    j = len(arr) - 1
    while arr[j] <= arr[i - 1]:
        j -= 1
    arr[i - 1], arr[j] = arr[j], arr[i - 1]
    
    # Reverse suffix
    arr[i : ] = arr[len(arr) - 1 : i - 1 : -1]
    return "".join(arr)

def main():
  for m in range(int(input())):
    print(biggerIsGreater(input()))

# Code Execution
if __name__ == '__main__':
    main()
