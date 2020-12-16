
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        //initialize a dummy node to the start of the linked List at index 0
        ListNode* dummyNode = new ListNode(0);
        dummyNode->next = head;  // update next pointer as head of the linked list
        
        // Assign two pointers a, b as dummyNode
        ListNode* a = dummyNode;
        ListNode* b = dummyNode; 
        
        //move one of the pointers 'a' ahead by n iterations 
        for(int i=0; i<n; i++){
            a = a->next;
        }
        
        //while pointer 'a' is not null, move both pointers 'a' and 'b' simulatneously
        while(a->next != NULL){
            b = b->next;
            a = a->next;    
        }
        
        //'a' pints to the last node and 'b' points to the node before the node to be removed. Update pointer 'b' by pointing it to the node connected to the node that is to be removed        
        b->next = b->next->next;
        
        //since dummyNode points to index zero, return the linked list from the node present next to the dummyNode        
        return dummyNode->next;
        
    }
};