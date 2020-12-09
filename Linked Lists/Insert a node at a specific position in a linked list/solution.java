package LinkedListEasy1;

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

        //Member method to insert a Node at a specific Position
        static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

            SinglyLinkedListNode nodeToInsert = new SinglyLinkedListNode(data);
            //Empty List - Returned newly created node or null
            if (head==null){
                return nodeToInsert;
            }
            //Inserting a Node ahead of the List
            if (position == 0){
                nodeToInsert.next = head;
                return nodeToInsert;
            }
            //Create a copy of Head Node
            SinglyLinkedListNode curr = head;
            //Traverse the Singly Linked List to 1 Position Prior
            //Stop traversing if you reached the end of the List
            int currPosition = 0;
            while (currPosition < position -1 && curr.next != null){
                curr = curr.next;
                currPosition++;
            }
            //Inserting a Node in-between a List or at the end of of a List
            nodeToInsert.next = curr.next;
            curr.next = nodeToInsert;
            return head;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            //Creating Singly Linked List
            SinglyLinkedList llist = new SinglyLinkedList();

            //Code for adding node at a specific position
            int data = scanner.nextInt();
            int position = scanner.nextInt();
            llist.head = insertNodeAtPosition(llist.head, data, position);

            //Call to Method to print out the Linked List
            printSinglyLinkedList(llist.head);
            scanner.close();
        }
    }
}
