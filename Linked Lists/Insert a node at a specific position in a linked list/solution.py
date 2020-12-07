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

def insertNodeAtPosition(head, data, position):
    if not head:
        head = SinglyLinkedListNode(data)
        return head
    if not position:
        temp = SinglyLinkedListNode(data)
        temp.next = head
        head = temp
    else :
        temp = head
        for i in range(position-1) :
            temp = temp.next
            if not temp:
                break
        if not temp:
            return None
        to_be_next = temp.next
        temp.next = SinglyLinkedListNode(data)
        temp.next.next = to_be_next
    return head

if __name__ == '__main__' :
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