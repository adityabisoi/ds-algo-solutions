import java.io.IOException;
import java.util.Scanner;

public class solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

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

    //Member method to print the data of the nodes of singlyLinkedList
    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        //Create two nodes one pointing to the head and
        //the other which would act as the previous node
        //currently pointing to null
        SinglyLinkedListNode curr = head, prev = null;
        //Iterate through the linked list
        while(curr != null) {
            //Create a new node that will store the value of next node
            SinglyLinkedListNode next = curr.next;
            //Point the next of current to previous
            curr.next = prev;
            //Point previous to current
            prev = curr;
            //Now finally point current to the next node
            curr = next;
        }
        //Return prev as this will now be our new head
        return prev;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int tests = scanner.nextInt();

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();
            int llistCount = scanner.nextInt();
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = reverse(llist.head);
            printSinglyLinkedList(llist1);
        }
        scanner.close();
    }
}

