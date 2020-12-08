class SinglyLinkedListNode: #class SinglyLinkedListNode has a data variable and a pointer to the next node
    def __init__(self, data):
        self.data = data
        self.next = None

def print_with_head(head) : #helper functioin to print the elements of the list
    temp = head
    while temp is not None :
        print(temp.data)
        temp = temp.next

def insert_at_head(head, data):
    temp = SinglyLinkedListNode(data) # create a new node for the new head
    temp.next = head # assign new head's next as previous head
    head = temp
    return head

if __name__ == '__main__' : # to test implementation
    print("Enter the size of the linked list : ")
    n = int(input())
    print("Enter list elements")
    head = None
    for i in range(n):
        head = insert_at_head(head, int(input()))
    print_with_head(head)
