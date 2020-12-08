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
//Method to print the data of linked list.
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


//Explanation of Algorithm.

//1. Get count of the nodes in the first list, let count be c1.
//2. Get count of the nodes in the second list, let count be c2.
//3. Get the difference of counts d = abs(c1 – c2)
//4. Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes 
//5. Then we can traverse both the lists in parallel till we come across a common node.       Get a common node is done by comparing the address of the nodes.

// getCount() Method counts the nodes in both the linked list.
 int getCount(SinglyLinkedListNode* head){
    SinglyLinkedListNode* current = head;
    int count =0;
    while(current != NULL){
        count++;
        current = current->next;
    }
    return count;
 }
 
 // getNode() Method returns the data of common node. 
 int getNode(int d,SinglyLinkedListNode* head1, SinglyLinkedListNode* head2 ){
     int i;
     SinglyLinkedListNode* current1 = head1;
     SinglyLinkedListNode* current2 = head2;
     
     //Traverse current1 pointer till first d nodes.
     for(i=0;i<d;i++){
         if(current1 == NULL) return -1;
         current1 = current1->next;
     }
     
     //Now parallely traverse both the linked lists till common node is reached.
     while(current1 != NULL && current2 != NULL){
        if(current1 == current2) return current1->data;
        current1 = current1->next;
        current2 = current2->next;
     }
     
     return -1;
 }
 
 //Method to search merge point in two linked lists.
int findMergeNode(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    int c1 = getCount(head1);
    int c2 = getCount(head2);
    int d;
    if(c1>c2){
        d=c1-c2;
        return getNode(d,head1,head2);
    }
    else{
        d=c2-c1;
        return getNode(d,head2,head1);
    }
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int tests;
    cin >> tests;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int tests_itr = 0; tests_itr < tests; tests_itr++) {
        int index;
        cin >> index;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        SinglyLinkedList* llist1 = new SinglyLinkedList();

        int llist1_count;
        cin >> llist1_count;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        for (int i = 0; i < llist1_count; i++) {
            int llist1_item;
            cin >> llist1_item;
            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            llist1->insert_node(llist1_item);
        }
      
      	SinglyLinkedList* llist2 = new SinglyLinkedList();

        int llist2_count;
        cin >> llist2_count;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        for (int i = 0; i < llist2_count; i++) {
            int llist2_item;
            cin >> llist2_item;
            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            llist2->insert_node(llist2_item);
        }
      
      	SinglyLinkedListNode* ptr1 = llist1->head;
      	SinglyLinkedListNode* ptr2 = llist2->head;
      
      	for (int i = 0; i < llist1_count; i++) {
            if (i < index) {
          		ptr1 = ptr1->next;
            }
        }
      
      	for (int i = 0; i < llist2_count; i++) {
          	if (i != llist2_count-1) {
          		ptr2 = ptr2->next;
            }
        }
      
      	ptr2->next = ptr1;

        int result = findMergeNode(llist1->head, llist2->head);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
