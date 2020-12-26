import math
def main():
    #input array size
    testcase = int(input())
    #input array elements
    med = [int(i) for i in input().split()]
    print(findmed(med))
#Output one integer, the median 
def findmed(med):
    med.sort()
    if(len(med)%2 == 1):
        return med[int(len(med)/2)]
    else:
        return (med[math.floor(len(med)/2)+math.ceil(len(med)/2)])/2
main()