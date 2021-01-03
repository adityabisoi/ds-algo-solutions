def main():
    n, m = map(int, input().split())
    c = list(map(int, input().split()))

    l = [10 ** 5] * n
    for x in c:
        l[x] = 0
    
    for i in range(1, len(l)):
        if l[i] == 0:
            continue
        else:
            l[i] = min(l[i], l[i - 1] + 1)

    for i in range(len(l) - 2, -1, -1):
        if l[i] == 0:
            continue
        else:
            l[i] = min(l[i], l[i + 1] + 1)

    print(max(l))

