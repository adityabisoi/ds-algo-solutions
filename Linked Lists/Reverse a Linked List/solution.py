#!/bin/python3

import math
import os
import random
import re
import sys


class SinglyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None


class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_node(self, node_data):
        node = SinglyLinkedListNode(node_data)

        if not self.head:
            self.head = node
        else:
            self.tail.next = node

        self.tail = node


def print_singly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)


# Consider an example
# head --> A --> B

# current_node = head
# previous = None

# When loop runs for the first time
# next_node = A
# None <-- head
# previous = head
# current_node = A

# When loop runs for second time
# next_node = B
# head <-- A
# previous = A
# current_node = B

# When loop runs for third time
# next_node = None
# A <-- B
# previous = B
# current_node = None

# Finally  None <-- A <-- B
# return previous i.e. B

def reverse(head):
    current_node = head
    previous = None

    while current_node:
        next_node = current_node.next

        current_node.next = previous  # reversing pointer

        # update values for next loop
        previous = current_node
        current_node = next_node

    return previous


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    tests = int(input())

    for tests_itr in range(tests):
        llist_count = int(input())

        llist = SinglyLinkedList()

        for _ in range(llist_count):
            llist_item = int(input())
            llist.insert_node(llist_item)

        llist1 = reverse(llist.head)

        print_singly_linked_list(llist1, ' ', fptr)
        fptr.write('\n')

    fptr.close()
