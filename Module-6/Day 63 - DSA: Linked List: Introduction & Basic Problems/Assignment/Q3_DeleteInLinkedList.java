/*
 * Q3. Delete in Linked List
Problem Description
You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.

Note : Follow 0-based indexing for the node numbering.



Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
0 <= B < size of linked list


Input Format
The first argument A is the head of a linked list.

The second arguement B is an integer.


Output Format
Return the head of the linked list after deletion



Example Input
Input 1:
A = 1 -> 2 -> 3
B = 1
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 0


Example Output
Output 1:
1 -> 3
Output 2:
3 -> 2 -> 1


Example Explanation
For Input 1:
The linked list after deletion is 1 -> 3.
For Input 2:
The linked list after deletion is 3 -> 2 -> 1.

 */

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x ){
        val = x;
        next = null;
    }
}
public class Q3_DeleteInLinkedList {

    public static void printLinkedList(ListNode A) {
        ListNode temp  = A;
        while(temp != null) {
            System.out.print(temp.val +" ");
            temp = temp.next; 
        }
        System.out.println();
    }

    public static ListNode solve(ListNode A, int B) {
        ListNode temp = A;
        if(B == 0) {
           temp = temp.next;
           return temp;
        }
        for(int  i = 0; i < B - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return A;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        printLinkedList(node1);
        node1 = solve(node1, 4);
        printLinkedList(node1);
    }
}
