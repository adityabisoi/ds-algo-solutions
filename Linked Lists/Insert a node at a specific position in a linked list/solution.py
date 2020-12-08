class SinglyLinkedListNode: #class SinglyLinkedListNode has a data variable and a pointer to the next node
    def __init__(self, data):
        self.data = data
        self.next = None

def print_with_head(head) : #helper function to print elements of the list
    temp = head
    while temp is not None :
        print(temp.data)
        temp = temp.next

def insert_at_tail(head, data): #helper function to create a list
    if not head :
        temp = SinglyLinkedListNode(data)
        head = temp
    else:
        temp = head
        while temp.next is not None :
            temp = temp.next
        temp.next = SinglyLinkedListNode(data)
    return head

def insertNodeAtPosition(head, data, position): 
    if not head: #if the list is empty assume position = 0
        head = SinglyLinkedListNode(data) # create a new node and assign it as head
        return head
    if not position: # same as insert at head of the list
        temp = SinglyLinkedListNode(data)
        temp.next = head
        head = temp
    else :
        temp = head
        for i in range(position-1) : #loop until the (position-1)th node of the list
            temp = temp.next
            if not temp:  #if position is greater than size of list
                break
        if not temp:
            return None
        to_be_next = temp.next #the next node to the node to be inserted
        temp.next = SinglyLinkedListNode(data) #create a new node at next of (position-1)th node
        temp.next.next = to_be_next #assign next of new node to the previous next
    return head

if __name__ == '__main__' : # to test implementation
    print("Enter the size of the linked list : ")
    n = int(input())
    print("Enter list elements : ")
    head = None
    for i in range(n):
        head = insert_at_tail(head, int(input()))
    print("Enter the data to be inserted : ")
    dat = int(input())
    print("Enter the position where the node is to be inserted : ")
    pos = int(input())
    insertNodeAtPosition(head, dat, pos)
    print_with_head(head)
