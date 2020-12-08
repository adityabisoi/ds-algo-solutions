/****** 

All functions except reverse() are pre-written. 
The user only need to complete the reverse() function 

******/

#include <bits/stdc++.h> // Header for doing I/O operations

using namespace std;

// Class of Linked List's Nodes
class SinglyLinkedListNode {
    public:
        int data;
        SinglyLinkedListNode *next;

        // Constructor for initializing data members (variables)
        SinglyLinkedListNode(int node_data) {
            this->data = node_data;
            this->next = nullptr;
        }
};

// Class of Linked Lists
class SinglyLinkedList {
    public:
        SinglyLinkedListNode *head;
        SinglyLinkedListNode *tail;

        // Constructor for initializing data members (variables)
        SinglyLinkedList() {
            this->head = nullptr;
            this->tail = nullptr;
        }

        // Function to insert a node in the Linked List
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

// Function to Print the Linked List
void print_singly_linked_list(SinglyLinkedListNode* node, string sep, ofstream& fout) {
    while (node) {
        fout << node->data;

        node = node->next;

        if (node) {
            fout << sep;
        }
    }
}

// Function to delete the Linked List
void free_singly_linked_list(SinglyLinkedListNode* node) {
    while (node) {
        SinglyLinkedListNode* temp = node;
        node = node->next;

        free(temp);
    }
}

SinglyLinkedListNode* reverse(SinglyLinkedListNode* head) {

    // This is the base case of the recursive function
    // If the address of the next node is NULL then the current node is the last node
    if(head->next == NULL) return head;

    // Recursively call reverse() function
    // The return value of the function (st) is the address of the Last node
    SinglyLinkedListNode* st = reverse(head->next);

    // While Backtracking , flip the direction of the current link
    // This reverses the Linked List

    head->next->next = head; // This operation is similar to changing [  ]->[  ] to [  ]<-[  ]

    head->next=NULL;         // This operation is similar to changing [  ]->[  ] to NULL<-[  ]  

    // Return the address of the last node , which is the new head
    return st;
}

// pre-written main() function
// Takes input from the user , declares Linked Lists and calls functions accordingly
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
