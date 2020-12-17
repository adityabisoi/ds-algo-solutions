#importing required modules
from collections import Counter
import time 
start = time.time()

#initializing variables
bigN = 2 ** 13
mod = 10 ** 9 + 7

#debug initially set to false
debug = False
resch = [1] * bigN
resch[0] = resch[1] = 0
for i in xrange(2, bigN):
    if resch[i]:
        for j in xrange(2*i, bigN, i):
            resch[j] = 0
primes = [id for id, a in enumerate(resch) if a]

#if false then q=5 otherwise q will be defined by the user
if debug:
    q = 5
else:    
    q = int(raw_input())
counter = [0] * 4501
for _ in xrange(q):
    if debug:
        arr = range(3500, 4500) * 100
    else:        
        raw_input()
        arr = map(int, raw_input().split())
    for a in arr:
        counter[a] += 1
    ans = {0:1}
    newAns = {}
    
    for a in xrange(3500, 4501):
        c = counter[a]
        counter[a] = 0
        if c == 0:
            continue

        if a not in ans:
#fetchings keys from ans set
            akeys = ans.keys()
            hc = (c + 1) / 2
            ans.update({a ^ k:  ans[k] * hc  % mod for k in akeys})

            hc = c / 2 + 1
            for k in akeys:
                ans[k] *= hc
        else:
            hc = c / 2 + 1
            hc2 = (c + 1) / 2

            ans = {k : (count * hc + ans[ k ^ a] * hc2) % mod for k, count in ans.iteritems()}

    print sum(ans.get(p, 0) for p in primes) % mod
if debug:
    print time.time() - start

