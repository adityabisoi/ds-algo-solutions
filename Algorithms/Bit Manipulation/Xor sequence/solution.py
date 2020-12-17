# solve function return the integer value calculated
def solve():
    left_side=0
    if (L+1)%4==0:
        ans=2
        left_side=L+5
    if L%4==0:
        ans=2
        left_side=L+4
    if (L+3)%4==0:
        ans=L+1
        left_side=L+3
    if (L+2)%4==0:
        ans=L+1
        left_side=L+2
    right_side=0
    if (R+1)%4==0:
        ans=ans^2
        right_side=R-3
    if (R-2)%4==0:
        ans=ans^2
        right_side=R-2
    if (R-1)%4==0:
        ans=ans^(R)
        right_side=R-1
    if (R%4)==0:
        ans=ans^R
        right_side=R
    diff=(right_side - left_side)/4
    if diff%2 != 0 : ans=ans^2
    return ans
# input number of questions
T=int(input())
for _ in range(T):
    # the inclusive left and right indexes of the segment to query
    L,R=map(int,input().split())
    print(solve())
