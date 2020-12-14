import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CompareTwoLinkedList {
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

    //Method to compare two Linked Lists
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        //Iterate through both the linked list till anyone of them becomes null
        while(head1 != null && head2 != null) {
            //If data of both at a position is different return false
            if(head1.data != head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        //If head of first Linked List points to null and head of second Linked List is not null return false
        if(head1 == null && head2 != null)
            return false;
        //If head of second Linked List points to null and head of first Linked List is not null return false
        if(head1 != null && head2 == null)
            return false;
        //If it passes all the conditions for being equal return true
        return true;
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
            //Compare the two LinkedLists and print the result as 0 or 1
            boolean result = compareLists(llist1.head, llist2.head);
            System.out.println(result ? 1 : 0);
        }
        scanner.close();
    }
}

