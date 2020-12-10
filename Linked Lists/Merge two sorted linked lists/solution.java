import java.io.IOException;
import java.util.Scanner;

public class MergeSortedLinkedLists {

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

    //Method to merge Two Linked Lists
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode a, SinglyLinkedListNode b) {
        //If first linked list points to null return b
        if (a == null) {
            return b;
        }
        //If second linked list points to null return a
        else if (b == null) {
            return a;
        }
        //If data at current node of first Linked List is smaller
        if (a.data < b.data) {
            //Assign next of a to result of recursive call of mergeLists method on
            //next node of first linked list and current node of second linked list
            a.next = mergeLists(a.next, b);
            return a;
        } else {
            //Assign next of b to result of recursive call of mergeLists method on
            //current node of first linked list and next node of second linked list
            b.next = mergeLists(a, b.next);
            return b;
        }
    }

    //Method to print the data of the nodes of singlyLinkedList
    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //Input the number of test cases
        int tests = scanner.nextInt();
        //For each test case
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            //Create first Linked List
            SinglyLinkedList llist1 = new SinglyLinkedList();
            int llist1Count = scanner.nextInt();
            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                llist1.insertNode(llist1Item);
            }

            //Create second Linked List
            SinglyLinkedList llist2 = new SinglyLinkedList();
            int llist2Count = scanner.nextInt();
            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                llist2.insertNode(llist2Item);
            }

            //Merge the two linked lists
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
            printSinglyLinkedList(llist3);
        }
        scanner.close();
    }

}

