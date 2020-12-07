class SinglyLinkedListNode: #class SinglyLinkedListNode has a data variable and a pointer to the next node
    def __init__(self, data):
        self.data = data
        self.next = None

def print_with_head(head) :
    temp = head
    while temp is not None :
        print(temp.data)
        temp = temp.next

def insert_at_tail(head, data):
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
    if not position:
        head = llist.head.next
        temp = None
        return head
    if not head:
        return None
    for i in range(position-1) :
        temp = temp.next
        if not temp:
            break
    if not temp :
        return None
    if not temp.next:
        return None
    to_be_deleted = temp.next
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