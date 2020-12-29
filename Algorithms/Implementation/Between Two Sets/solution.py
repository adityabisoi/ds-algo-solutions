if __name__=='__main__':
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    ans = 0
    for i in range(1,101):
        flag = True
        for j in a:
            if i%j!=0:
                flag = False
                break
        if flag:
            for k in b:
                if k%i!=0:
                    flag = False
                    break
        if flag:
            ans+=1
    print(answer)