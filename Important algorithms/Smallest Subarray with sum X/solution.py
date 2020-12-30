#Question link
#https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x/0


def window(arr,n, k):
    left=0
    right=0
    ans=n
    sum1=0
    while left<n and right<n+1:
            if sum1>k:
                if left==right:
                    ans=1
                    break
                ans=min(ans,right-left)
                sum1-=arr[left]
                left+=1
            elif right==n:
                break
            else:
                
                sum1+=arr[right]
                right+=1
    return ans

def main():
    t = int(input())
    for _ in range(t):
        n, k = map(int,input().split())
        arr = list(map(int,input().split()))
        print(window(arr,n,k))
        
if __name__ == "__main__":
    main()
        
    
