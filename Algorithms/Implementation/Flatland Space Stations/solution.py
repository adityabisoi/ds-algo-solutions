def main():
    n, m = map(int, input().split())
    c = list(map(int, input().split()))

    l = [10 ** 5] * n
    for x in c:
        l[x] = 0