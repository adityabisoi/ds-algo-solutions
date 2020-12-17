#!/bin/python3

class Graph:
  def __init__(self, n_vertices):
    self.n_vertices = n_vertices
    self.edges = [set() for i in xrange(n_vertices)]

  def set_value(self, i, val):
    self.value[i] = val

  def add_edge(self, i, j):
    self.edges[i].add(j)
    self.edges[j].add(i)

  def connected_components(self):
    remaining  = set(xrange(self.n_vertices))
    discovered = [False]*self.n_vertices

    while remaining:
      # get arbitrary start element
      start = remaining.pop()

      # initialize component and stack
      component = []
      stack = [start]
      
      while stack:
        u = stack.pop()
        if not discovered[u]:
          component.append(u)
          discovered[u] = True
          for neighbor in self.edges[u]:
            stack.append(neighbor)

      # remove component from remaining
      for v in component:
        if v==start: continue
        else: remaining.remove(v)

      yield component

choose3 = lambda n: 0 if n<3 else n*(n-1)*(n-2)/6 #optimized calc of binomial(n,3)
choose2 = lambda n: 0 if n<2 else n*(n-1)      /2 #optimized calc of binomial(n,2)

N = int(raw_input())
G = Graph(N)
for _ in xrange(N-1):
  u,v,color = raw_input().strip().split()
  if color == 'b':
    G.add_edge(int(u)-1,int(v)-1)

total = choose3(N)
for component in G.connected_components():
  size = len(component)
  #// subtract all triplets build from 2 vertices of the components and 1 other vertex
  total -= choose3(size) + choose2(size) * (N-size) #total triplets

print total % (10**9 + 7) #If the answer is greater than 10^9 + 7, print the answer modulo (%) 10^9 + 7.