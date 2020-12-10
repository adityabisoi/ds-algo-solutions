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

    //Method to print the data of the nodes of singlyLinkedList
    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    /*
        Method to find the merge point
        Firstly Create pointers that iterates through the lists.
        When it's at the end of the list,
        have it jump to the beginning of the other list.
        The pointers will collide at the merge point after 1 or 2 passes.
     */
    static int findMergeNode(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        SinglyLinkedListNode currA = headA;
        SinglyLinkedListNode currB = headB;

        while (currA != currB) {
            //If currA's next point to null jump to the beginning of the other list
            if (currA.next == null) {
                currA = headB;
            }
            //Simply travese through list1
            else {
                currA = currA.next;
            }
            //If currB's next point to null jump to the beginning of the other list
            if (currB.next == null) {
                currB = headA;
            }
            //Simply travese through list2
            else {
                currB = currB.next;
            }
        }
        //Return the data of the merge point
        return currA.data;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        for (int tItr = 0; tItr < t; tItr++) {
                int index = scanner.nextInt();

                SinglyLinkedList llist1 = new SinglyLinkedList();

                int llist1Count = scanner.nextInt();
                for (int i = 0; i < llist1Count; i++) {
                    int llist1Item = scanner.nextInt();
                    llist1.insertNode(llist1Item);
                }

                SinglyLinkedList llist2 = new SinglyLinkedList();
                int llist2Count = scanner.nextInt();
                for (int i = 0; i < llist2Count; i++) {
                    int llist2Item = scanner.nextInt();
                    llist2.insertNode(llist2Item);
                }

                SinglyLinkedListNode ptr1 = llist1.head;
                SinglyLinkedListNode ptr2 = llist2.head;
                for (int i = 0; i < llist1Count; i++) {
                    if (i < index) {
                        ptr1 = ptr1.next;
                    }
                }
                for (int i = 0; i < llist2Count; i++) {
                    if (i != llist2Count-1) {
                        ptr2 = ptr2.next;
                    }
                }

                ptr2.next = ptr1;

                int result = findMergeNode(llist1.head, llist2.head);
                System.out.println(result);
            }
        scanner.close();
    }
}
