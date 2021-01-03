import sys

prime_pre = [0 for i in range(100001)]
sieve = [0 for i in range(100001)]
for i in range(2, 100000):
    if sieve[i] == 0:
        prime_pre[i] = prime_pre[i-1]+1
        #primes.append(i)
        for j in range(i, 100001, i):
            sieve[j] = i
    else:
        prime_pre[i] = prime_pre[i-1]

g = int(input().strip())
for a0 in range(g):
    n = int(input().strip())
    print("Bob" if prime_pre[n]%2 == 0 else "Alice")