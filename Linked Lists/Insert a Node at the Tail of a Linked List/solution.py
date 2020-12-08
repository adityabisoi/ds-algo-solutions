class SinglyLinkedListNode: #class SinglyLinkedListNode has a data variable and a pointer to the next node
    def __init__(self, data):
        self.data = data
        self.next = None

def print_with_head(head) : #helper function to print elements of the list
    temp = head
    while temp is not None :
        print(temp.data)
        temp = temp.next

def insert_at_tail(head, data):
    if not head : #if the list is empty
        temp = SinglyLinkedListNode(data) #create a new node and assign it as head 
        head = temp
    else:
        temp = head
        while temp.next is not None : #move to the next node until tail of the current list is found
            temp = temp.next
        temp.next = SinglyLinkedListNode(data) # create new tail node and assign previous tail next to it
    return head

if __name__ == '__main__' : #to test code
    print("Enter the size of the linked list : ")
    n = int(input())
    print("Enter list elements")
    head = None
    for i in range(n):
        head = insert_at_tail(head, int(input()))
    print_with_head(head)
