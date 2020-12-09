import java.util.Scanner;

public class PrintLinkedListInReverse {

    //SinglyLinkedListNode class to represent a node
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    //SinglyLinkedList class to represent a linked list
    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;
        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }
        //Method to insert Node in the linked list
        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    //Method to print Linked List in reverse order
    //The below method makes use of recursion
    static void reversePrint(SinglyLinkedListNode head) {
        //Base case that checks if head is null
        if(head == null)
            return;
        //Recursive call to method by pass next node
        reversePrint(head.next);
        //Finally printing out the data of current node
        System.out.println(head.data);
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Input the number of test cases
        int tests = scanner.nextInt();
        //For each test case
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();
            //Input the number of nodes in linked list
            int llistCount = scanner.nextInt();
            //Input the data for the nodes and insert them in the linked list
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                llist.insertNode(llistItem);
            }
            //Finally call the method to recursively print the linked list in reverse order
            reversePrint(llist.head);
        }
        scanner.close();
    }
}
