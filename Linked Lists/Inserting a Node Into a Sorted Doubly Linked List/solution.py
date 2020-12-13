#!/bin/python3

import math
import os
import random
import re
import sys

class DoublyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_node(self, node_data):
        node = DoublyLinkedListNode(node_data)

        if not self.head:
            self.head = node
        else:
            self.tail.next = node
            node.prev = self.tail


        self.tail = node

def print_doubly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)

# Sorted Insert Function            

def sortedInsert(head, data):
    newNode=DoublyLinkedListNode(data)
    
    if head==None:                  # if Linked List is empty
        head=newNode
        
    elif head.data>=newNode.data:   # if Node is to be inserted at start
        newNode.next=head
        head.prev=newNode
        head=newNode
        
    else:                           # if Node is to be inserted at any further position
        temp=head
        while temp.next is not None and data>temp.next.data:
            temp=temp.next
        if temp.next==None:             # inserting at last
            temp.next=newNode
            newNode.prev=temp
        else:
            next=temp.next
            temp.next=newNode
            newNode.prev=temp
            newNode.next=next
            next.prev=newNode
    return head

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        llist_count = int(input())

        llist = DoublyLinkedList()

        for _ in range(llist_count):
            llist_item = int(input())
            llist.insert_node(llist_item)

        data = int(input())

        llist1 = sortedInsert(llist.head, data)

        print_doubly_linked_list(llist1, ' ', fptr)
        fptr.write('\n')

    fptr.close()
