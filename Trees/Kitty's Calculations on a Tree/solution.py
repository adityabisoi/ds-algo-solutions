#!/bin/python
# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
import heapq
def dfs_find_prefix(node):
    stack = [node]
    prefix[node]=-1
    depth[node] = 0
    stack=[[node,-1]]
    pre= str(node)
    passed.add(node)
    ii = 0      # next child idx
    while stack!=[]:
        #print stack
        node = stack[-1][0]
        if ii < node_degree[node-1]:
            neigh = node_neigh[node-1][ii]
            if neigh not in passed:
                prefix[neigh-1] = node-1
                depth[neigh-1]=depth[node-1]+1
                stack.append([neigh,ii])
                passed.add(node)
                ii = 0
            else:
                ii+=1
        else:
            _, ii = stack.pop()
            ii+=1          

def find_LCA(node):
   
    while node != 0 and node not in LCA_set:
        
        node = prefix[node-1]+1
        #print node
    return node
    
def find_all_LCA():
    tmp = set()
    #print node_set
    for node in node_set:
        node-=1
        
        while node!=-1:
            if node not in tmp:
                tmp.add(node)
                node = prefix[node]
            else:
                LCA_set.add(node+1)
                break
                
   
    return
    

# joint node1 and its Ancestor
def joint(node0,node1):  
     
    if node0==node1:
        return 0
    p0 = packages.get(node0,0)
    
    e0 = elements.get(node0,0)
    p1 = packages.get(node1,0)
    e1 = elements.get(node1,0)
    
    p1+= e1*(depth[node1-1]-depth[node0-1])
    #print 'dep-diff',(depth[node1-1]-depth[node0-1]),depth
    result = p0*e1+p1*e0
    elements[node0] = e0+e1
    packages[node0] = p0+p1
    
    
    return result



n_node,n_set = map(int,sys.stdin.readline().strip().split())
# number of nodes in tree, number of nodes need to be compute

node_neigh = [[] for i in range(n_node)]
node_degree = [ 0 for i in range(n_node)]
# neighbors and degree of each node



SystemExit
for i in range(n_node-1):
    n1,n2 = map(int,sys.stdin.readline().strip().split())
    node_neigh[n1-1].append(n2)
    node_neigh[n2-1].append(n1)
    node_degree[n1-1]+=1
    node_degree[n2-1]+=1
# get neighbors and degree of each node

# find root
for i in range(n_node-1):
    if node_degree[i]==1:
        break
root = i+1

# find prefix & depth of each node
prefix = [-1]*n_node
depth = [0]*n_node
passed = set()
dfs_find_prefix(root)


# starting ....
for i in range(n_set):
    # read each set of nodes
    set_size = int(sys.stdin.readline().strip())
    set_node =(map(int,sys.stdin.readline().strip().split()))
    node_set = set(set_node)
    
    
    
    if set_size<2:
        print 0
        continue
    # find all possible LCAs of the set
    LCA_set = set()
    find_all_LCA()
    
    elements,packages={node:node for node in node_set},{node:0 for node in node_set}
    result = 0
    next_node=[]
    

    for node in set_node:
        anc = find_LCA(node)
        #print node, 'anc', anc
        heapq.heappush(next_node,[-depth[anc-1],anc])
        result+=joint(anc,node)
    
    count = 0
    while next_node!=[]:
        #print next_node,LCA_set
        node = heapq.heappop(next_node)[1]
    
        if node in LCA_set:
            LCA_set.remove(node)
            anc = find_LCA(node)
            #print node,'anc' , anc
            if anc != 0:
                heapq.heappush(next_node,[-depth[anc-1],anc])
                result+=joint(anc,node)
        
    #print packages
    #print elements
    print result%(10**9+7)
""