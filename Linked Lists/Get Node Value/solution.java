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

    //Method to get the value of the node
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode curr   = head;
        SinglyLinkedListNode runner = head;
        /* Move runner into the list by k elements */
        for (int i = 0; i < positionFromTail; i++) {
            runner = runner.next;
        }
        /* Move both pointers */
        while (runner.next != null) {
            curr   = curr.next;
            runner = runner.next;
        }
        return curr.data;
    }

    private static final Scanner scanner = new Scanner(System.in);
    //Driver Code
    public static void main(String[] args) throws IOException {
        int tests = scanner.nextInt();
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();
            int llistCount = scanner.nextInt();
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                llist.insertNode(llistItem);
            }
            int position = scanner.nextInt();
            int result = getNode(llist.head, position);
            System.out.println(result);
        }
        scanner.close();
    }
}
