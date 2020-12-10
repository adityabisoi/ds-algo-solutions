#include <bits/stdc++.h>

using namespace std;
class SinglyLinkedListNode {
    public:
        int data;
        SinglyLinkedListNode *next;

        SinglyLinkedListNode(int node_data) {
            this->data = node_data;
            this->next = nullptr;
        }
};


class SinglyLinkedList {
    public:
        SinglyLinkedListNode *head;
        SinglyLinkedListNode *tail;

        SinglyLinkedList() {
            this->head = nullptr;
            this->tail = nullptr;
        }
        //Method to print the data of the Linked List.
        void insert_node(int node_data) {
            SinglyLinkedListNode* node = new SinglyLinkedListNode(node_data);

            if (!this->head) {
                this->head = node;
            } else {
                this->tail->next = node;
            }

            this->tail = node;
        }
};
//Method to print the data of Linked List
void print_singly_linked_list(SinglyLinkedListNode* node, string sep, ofstream& fout) {
    while (node) {
        fout << node->data;

        node = node->next;

        if (node) {
            fout << sep;
        }
    }
}

void free_singly_linked_list(SinglyLinkedListNode* node) {
    while (node) {
        SinglyLinkedListNode* temp = node;
        node = node->next;

        free(temp);
    }
}
//Consider an example: Head->1->2->Null
//Initially current = head , previous = NULL

// IST iteration
//Next = 1
//NULL <- head
//prev = head
//current = 1

// 2ND iteration
//Next = 2
//head <- 1
//prev = 1
//current = 2

// 3RD iteration
//Next = NULL
//1 <- 2
//prev = 2
//current = NULL

//Finally head becomes 2
//head -> 2 -> 1 -> NULL


//Method to reverse data of Linked List
SinglyLinkedListNode* reverse(SinglyLinkedListNode* head) {
     //Three nodes are created: *Current , *Node , *Next.
     //Current shows the present node(Initially Head).

     SinglyLinkedListNode *next , *current , *prev;
     current = head ;
     prev = NULL;

     while(current != NULL){
         next = current->next;//Next points to successive node of current node.
         current->next = prev;//Current node now points to preceeding node.
         prev = current;//Previous now becomes Current Node.
         current = next;//Current now becomes the next node.
     }

     head = prev;//Previous now becomes the Head node.
     return head; 

}
int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int tests;
    cin >> tests;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int tests_itr = 0; tests_itr < tests; tests_itr++) {
        SinglyLinkedList* llist = new SinglyLinkedList();

        int llist_count;
        cin >> llist_count;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        for (int i = 0; i < llist_count; i++) {
            int llist_item;
            cin >> llist_item;
            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            llist->insert_node(llist_item);
        }

        SinglyLinkedListNode* llist1 = reverse(llist->head);

        print_singly_linked_list(llist1, " ", fout);
        fout << "\n";

        free_singly_linked_list(llist1);
    }

    fout.close();

    return 0;
}
