# return the number of combinaison for a wall of length N. Use memoization
nbCombMem = ([],[])
def nbComb(N) :
   if N in nbCombMem[0] :
      return nbCombMem[1][nbCombMem[0].index(N)]
   if N < 0 : return 0
   c = 1
   for i in range(0,N-3) :
      c += nbComb(N-4-i)
   nbCombMem[0].append(N)
   nbCombMem[1].append(c)
   return c

# return the primes (strictly) under n. Use a sieve of erathostene
def getPrimesUnder(n) :
   r = [2]
   n2 = n // 2
   l = list(True for i in range(0,n2))
   l[0] = False
   for i in range(1,n2) :
      if l[i] :
         r.append(2*i+1)
         for m in range(2*i*(i+1),n2,2*i+1) :
            l[m] = False
   return r

# main module
T = int(input())
Cs = [nbComb(int(input())) for t in range(0,T)]

Ps = getPrimesUnder(max(Cs)+1)

for t in range(0,T) :
    c = 0
    while c < len(Ps) and Ps[c] <= Cs[t] : c += 1
    # Print the integer on a separate line for each test case
    print(c)

