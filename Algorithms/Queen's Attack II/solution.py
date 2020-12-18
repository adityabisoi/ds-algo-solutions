def queensAttack(N, k, rq, cq, obstacles):  # N = size of board
    n = N - rq    # north
    s = rq-1    # south
    e = N - cq    # east
    w = cq-1    # west
    
    # taking minimum because cannot go out of board
    ne = min(n, e)    # north east
    se = min(s, e)    # south east
    nw = min(n, w)    # north west
    sw = min(s, w)    # south west
    
    # finding closest obstacle in all directions
    for o in obstacles:
        if o[1] == cq:   # same column
            if o[0] < rq:
                s = min(s, rq-1-o[0])
            else:
                n = min(n, o[0]-rq-1)
        elif o[0] == rq:    # same row
            if o[1] < cq:
              w = min(w, cq-1-o[1])
            else:
              e = min(e, o[1]-cq-1)
        elif abs(o[0]-rq) == abs(o[1]-cq):    # diagonals
            if o[1]>cq:
                if o[0]>rq:
                  ne = min(ne, o[1]-cq-1)
                else:
                  se = min(se, o[1]-cq-1)
            else:
                if o[0]>rq:
                  nw = min(nw, cq-1-o[1])
                else:
                  sw = min(sw, cq-1-o[1])
                
    return n + s + e + w + ne + se + sw + nw

if __name__ == '__main__':
  [N, k] = list(map(int, input().rstrip().split()))
  [rq, cq] = list(map(int, input().rstrip().split()))
  obs = []
  for kk in range(k):
    obs.append(list(map(int, input().rstrip().split())))
    
  attack = queensAttack(N, k, rq, cq, obs)
  print(attack)