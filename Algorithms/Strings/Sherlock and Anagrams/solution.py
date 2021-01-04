# input number of queries
T = int(input())
while T > 0:
    T -= 1
    # input the strings
    S = input()
    l = len(S)
    ans = 0
    for i in range(l - 1):
        for j in range(l - i):
            sb = S[i: (i + j + 1)]
            sb = sorted(sb)
            for k in range(i + 1, l - j):
                sb2 = S[k: (k + j + 1)]
                sb2 = sorted(sb2)
                if sb == sb2:
                    ans += 1
    #  output the number of unordered anagrammatic pairs of substrings in string s
    print(str(ans))