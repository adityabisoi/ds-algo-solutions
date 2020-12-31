
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
    


