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

# Complete the getNode function below.

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#
#
def getNode(head, positionFromTail):    
    x=0
    temp=head
    
    while head:  #Finding the number of elements in the linked list
        x+=1
        head=head.next
    y=x- positionFromTail #Indexing from start of the list -> n - positionfromTail
    z=0
    while temp:  #Running the loop until we get the index from start
        y-=1
        if not y:
            z=temp.data
            break 
        temp=temp.next
    
    return z
if __name__ == '__main__':