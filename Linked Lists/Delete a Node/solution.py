class SinglyLinkedListNode: #class SinglyLinkedListNode has a data variable and a pointer to the next node
    def __init__(self, data):
        self.data = data
        self.next = None

def print_with_head(head) : #print a linked list when head is given
    temp = head
    while temp is not None : #loop until the Null/grounded node is found
        print(temp.data)
        temp = temp.next

def insert_at_tail(head, data): #helper fucntion
    if not head :
        temp = SinglyLinkedListNode(data)
        head = temp
    else:
        temp = head
        while temp.next is not None :
            temp = temp.next
        temp.next = SinglyLinkedListNode(data)
    return head

def deleteNode(head, position):
    temp = head
    if not position: #if the head is to be deleted
        head = head.next
        temp = None 
        return head
    if not head: #if the linked list is empty
        return None
    for i in range(position-1) : #move to (position - 1)th node to delete the next node
        temp = temp.next
        if not temp: #if position is greater than size of the linked list
            break
    if not temp : # only if size is less than position
        return None
    if not temp.next: #if the current node is a tail
        return None
    to_be_deleted = temp.next # (position)th node to be deleted
    temp.next = to_be_deleted.next
    to_be_deleted = None
    return head

if __name__ == '__main__' :
    print("Enter the size of the linked list : ")
    n = int(input())
    print("Enter list elements")
    head = None
    for i in range(n):
        head = insert_at_tail(head, int(input()))
    print("Enter the position of the node to be deleted")
    pos = int(input())
    head = deleteNode(head, pos)
    print_with_head(head)
