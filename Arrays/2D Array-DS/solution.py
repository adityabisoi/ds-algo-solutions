# Hourglass method
def hourglasssum(arr):
    maxsum = -999999999  # Stores the maximum sum
    for i in range(4):
        for j in range(4):
            # sum of hourglass
            sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]
            if sum > maxsum:
                maxsum = sum
    return maxsum                                   # returns maximum hourglass sum


def main():
    arr = [[None] * 6] * 6  # 2-D array
    for i in range(6):
        arr[i] = list(map(int, input().split(' ')))  # taking input from single line
    print(hourglasssum(arr))

    return 0
# Code Execution
if __name__ == '__main__':
    main()
