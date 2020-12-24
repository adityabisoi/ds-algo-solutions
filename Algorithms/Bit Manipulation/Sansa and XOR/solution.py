# Logic :
# if number of elements in the array is even, then the result will be zero
# if number of elements is odd, then simply XOR-ing the elements at odd places
# will give the desired result

def sansaXor(arr):
  if len(arr) % 2 == 0:     # even number of elements
    return 0
  else:
    ans = 0
    for i in range(0, len(arr), 2):     # odd places only
      ans = ans ^ arr[i]
    return ans

if __name__ == '__main__':
  t = int(input())      # test cases
  for tt in range(t):
    n = int(input())        # number of elements
    arr = list(map(int, input().rstrip().split()))      # elements list
    res = sansaXor(arr)
    print(res)