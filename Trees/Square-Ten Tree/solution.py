import sys
import cProfile



class output_result:
    ROOT_UPDATE = 0
    LEFT_TREE_UPDATE = 1
    RIGHT_TREE_UPDATE = 2

    def __init__(self):
        self.root = []
        self.ltree = []
        self.rtree = []
        self.bt_cnt = 0
        self.obuf = ""
   #for inserting the node
    def __insert_node(self, node, tree_update):
        if (tree_update == self.LEFT_TREE_UPDATE):
            nl = []
            nl.insert(0, node)
            if (len(self.ltree) > 0):
                t = self.ltree.pop(0)
                nl.insert(1, t)
                nl.insert(2, [])
            else:
                nl.insert(1, [])
                nl.insert(2, [])
            self.ltree.insert(0, nl)
        elif (tree_update == self.RIGHT_TREE_UPDATE):
            nl = []
            nl.insert(0, node)
            if (len(self.rtree) > 0):
                t = self.rtree.pop(0)
                nl.insert(1, [])
                nl.insert(2, t)
            else:
                nl.insert(1, [])
                nl.insert(2, [])
            self.rtree.insert(0, nl)
        else:
            self.root.insert(0, node)
            if (len(self.ltree) > 0):
                self.root.insert(1, self.ltree[0])
            else:
                self.root.insert(1, [])
            if (len(self.rtree) > 0):
                self.root.insert(2, self.rtree[0])
            else:
                self.root.insert(2, [])
        if len(node[1]) > 0 and node[1][0] != 0:
            self.bt_cnt += 1
        return
#for tree traversal
    def __inorder_traversal(self, node):
        if (len(node[1]) > 0):
            self.__inorder_traversal(node[1])

        if len(node[0][1]) > 0:
            outputstr = ''.join(map(str, node[0][1]))
            if (outputstr != "0"):
                self.obuf += str(node[0][0]) + " " + outputstr + "\n"

        if (len(node[2]) > 0):
            self.__inorder_traversal(node[2])
        return

    def get_root(self):
        return self.root

    def get_tree_cnt(self):
        return self.bt_cnt

    def left_tree_add(self, node):
        self.__insert_node(node, self.LEFT_TREE_UPDATE)
        return

    def right_tree_add(self, node):
        self.__insert_node(node, self.RIGHT_TREE_UPDATE)
        return

    # add the root node
    def root_add(self, node):
        self.__insert_node(node, self.ROOT_UPDATE)
        return

    # print the output result
    def print_output(self):
        sys.stdout.write(str(self.bt_cnt) + "\n")
        self.__inorder_traversal(self.root)
        sys.stdout.write(self.obuf)
        return

# each entry is stored as (asl, max-entries, mav-value)
ores = []
l = 0
r = 0
clv = 0


def create_ten_power_x_list(k):
    if (k <= 1):
        return [1, 0], 1
    rl = [1]
    r2p = 0
    if (k > 1):
        r2p = pow(2, k - 1)
        rl = rl + [0]*r2p
    return rl, r2p


# algo for a + b
def add_two_int_list(x, y):
    # look for largest possible level
   
    al = len(x)
    bl = len(y)
    if (bl == 0):
        a = x[:]
    elif (al == 0):
        a = y[:]
    else:
        if (al < bl):
            a = y[:]
            minl = al
            b = x
            maxl = bl
        elif (bl < al):
            a = x[:]
            maxl = al
            b = y
            minl = bl
        else:
            a = x[:]
            b = y
            maxl = al
            minl = bl

        carry = 0
        i = 1
        entries = 0
        # a >= b as per this logic and result is also stored in a
        while entries < minl:
            sum_t = b[minl - i] + a[maxl - i] + carry
            if (sum_t >= 10):
                carry = 1
                a[maxl - i] = sum_t - 10
            else:
                carry = 0
                a[maxl - i] = sum_t
            i += 1
            entries += 1

        # if carry > 0, then we need to do some more work
        i = maxl - minl - 1
        while carry > 0 and i >= 0:
            sum_t = a[i] + carry
            if (sum_t >= 10):
                carry = 1
                a[i] = sum_t - 10
            else:
                a[i] = sum_t
                carry = 0
            i -= 1

        if (carry == 1):
            a = [1] + a

        if (a[0] == 0):
            a.pop(0)
  
    return a


# algo for a - b
def del_two_int_list(x, y):
    al = len(x)
    bl = len(y)
 

    if al < bl:
        return []

    a = x[:]
    b = y

    if al == bl and a[0] < b[0]:
        return []

    a_i = al - 1
    b_i = bl - 1
    while (b_i >= 0):
        # subtraction borrow logic
        if (a[a_i] < b[b_i]):
            a[a_i] = 10 + a[a_i]
            i = 1
            while a[a_i - i] == 0:
                a[a_i - i] = 9
                i += 1
            a[a_i - i] -= 1
        # subtract logic
        a[a_i] = a[a_i] - b[b_i]
        a_i -= 1
        b_i -= 1

    i = 0
    while i < al:
        if a[i] != 0:
            break
        i += 1
    if i > 0:
        a = a[i:]
    # print "a: " + str(a)
    return a


def compare_two_list_int(a, b):
    a1 = len(a)
    b1 = len(b)

    if a1 > b1:
        return 1
    elif a1 < b1:
        return -1
    else:
        i = 0
        while (i < a1):
            if (a[i] != b[i]):
                if (a[i] > b[i]):
                    return 1
                else:
                    return -1
            i += 1
        return 0


# a % b where b is the number of zeroes in 10
def divmod_10_list_int(x, b, mod_reqd):
    
    c = []
    a = x[:]
    al = len(a)
    if b >= len(a):
        return a, [0]
    if mod_reqd is True:
        c = a[al - b:]
        i = 0
        while i < len(c):
            if c[i] != 0:
                break
            i += 1
        c = c[i:]
    a = a[:al - b]
    return c, a


def range_traverse():
    global clv, l, r, ores
    clv_me, clv_10s = create_ten_power_x_list(clv)
   
    range_diff = del_two_int_list(r, l)
    if compare_two_list_int(range_diff, clv_me) >= 0:
        modl, divl = divmod_10_list_int(l, clv_10s, True)
        del divl
        lent = del_two_int_list(clv_me, modl)
        if compare_two_list_int(lent, clv_me) == 0:
            lent = [0]
        rent, rentr = divmod_10_list_int(r, clv_10s, True)
        tmpl = add_two_int_list(l, lent)
      
        modl, l = divmod_10_list_int(tmpl, clv_10s, False)
        del tmpl
        del modl
        modr, r = divmod_10_list_int(del_two_int_list(r, rent), clv_10s, False)
        del modr
        
        ores.left_tree_add((clv, lent))
        ores.right_tree_add((clv, rent))
        clv += 1
        del range_diff
        range_traverse()
    else:
        ent = range_diff
        modent, divent = divmod_10_list_int(ent, clv_10s, True)
 
        ores.root_add((clv, modent))
        del range_diff
    return


# @profile
def main():
    global ores, l, r
    ores = output_result()
    l = list(map(int, (sys.stdin.readline()).strip()))
    r = list(map(int, (sys.stdin.readline()).strip()))
    l = del_two_int_list(l, [1])
    range_traverse()
    ores.print_output()
    return


enable_profiling = 0
if __name__ == "__main__":
    if (len(sys.argv) == 2):
        if (sys.argv[1] == "profile"):
            enable_profiling = 1
        else:
            print("usage: %s profile <optional>" % sys.argv[0])
            exit(-1)
    if (len(sys.argv) > 2):
        print("usage: %s profile <optional>" % sys.argv[0])
        exit(-1)

    if (enable_profiling == 1):
        cProfile.run('main()')
    else:
        main()
    sys.exit(0)
# p.s. the problem is way too complex and intricated. Skip this problem if you have not much knowledge about the topic. 