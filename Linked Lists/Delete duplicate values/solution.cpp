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
//Method to print the data of each node in linked list.
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
// Consider an example : head -> 1 -> 2 -> 2 -> 3 -> NULL
// Initially current = head 

//IST iteration
//Check (1 == 2) ? : NO
//current = 2;

//2ND iteration
//Check (2 == 2) ? : YES
//next1 = 2 (stored in 3rd node)
//delete the previous node
//current = 2

//3RD iteration
//Check (2 == 3) ? : NO
//current = 3;

//Finally the linked list becomes : head -> 1 -> 2 -> 3 -> NULL


SinglyLinkedListNode* removeDuplicates(SinglyLinkedListNode* head) {

    SinglyLinkedListNode* current = head;//Pointer to traverse linked list 
    SinglyLinkedListNode* next1; 
  
    while (current->next != NULL){  
        //Compare the data of current and successive node.
        if (current->data == current->next->data){  
        //The sequence of steps is important.If match occurs delete the present node
        //Assign current to successive node.        
        next1 = current->next->next;  
        free(current->next);  
        current->next = next1;  
        }  
    else{ // Advance if no match occurs.
        current = current->next;  
        }  
    }
    return head;  

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int t_itr = 0; t_itr < t; t_itr++) {
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

        SinglyLinkedListNode* llist1 = removeDuplicates(llist->head);

        print_singly_linked_list(llist1, " ", fout);
        fout << "\n";

        free_singly_linked_list(llist1);
    }

    fout.close();

    return 0;
}
