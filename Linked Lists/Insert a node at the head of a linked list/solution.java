import java.io.IOException;
import java.util.Scanner;

public class solution {
        //Class for Node
        static class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;
            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }

        //Class for Linked List
        static class SinglyLinkedList {
            public SinglyLinkedListNode head;
            public SinglyLinkedList() {
                this.head = null;
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

        //Member method to insert Node at Head
        static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
            SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
            //If head is null simply point head to temp and return head
            if (llist == null) {
                llist = temp;
                return llist;
            }
            //Point next of the new node created to head
            temp.next = llist;
            //Point head to temp
            llist = temp;
            //Return the head
            return llist;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            //Creating Singly Linked List
            SinglyLinkedList llist = new SinglyLinkedList();

            //Code for adding node at head of Linked list
            int llistCount = scanner.nextInt();
            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);
                llist.head = llist_head;
            }

            //Call to Method to print out the Linked List
            printSinglyLinkedList(llist.head);
            scanner.close();
        }
    }
}
