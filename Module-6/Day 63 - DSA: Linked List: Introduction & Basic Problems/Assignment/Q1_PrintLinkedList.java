/*
 * Q1. Print Linked List
Problem Description
You are given A which is the head of a linked list. Print the linked list in space separated manner.

Note : The last node value must also be succeeded by a space and after printing the entire list you should print a new line



Problem Constraints
1 <= size of linked list <= 105

1 <= value of nodes <= 109



Input Format
The first argument A is the head of a linked list.


Output Format
You dont need to return anything


Example Input
Input 1:
A = 1 -> 2 -> 3
Input 2:
A = 4 -> 3 -> 2 -> 1


Example Output
Output 1:
1 2 3
Output 2:
4 3 2 1


Example Explanation
For Input 1:
We print the given linked list
For Input 2:
We print the given linked list

 */

import java.util.List;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Q1_PrintLinkedList {

    public static void solve(ListNode A) {
        ListNode temp  = A;
        while(temp != null) {
            System.out.print(temp.val +" ");
            temp = temp.next; 
        }
        System.out.println();
    }

    public static ListNode insertAtFirstPos(ListNode A, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = A;
        A = newNode;
        return newNode;
    }

    public static ListNode insertAtLastPos(ListNode A, int val) {
        ListNode newNode = new ListNode(val);
        ListNode temp = A;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return A;
    }

    public static ListNode insertAtIndex(ListNode A, int val, int idx) {
        ListNode newNode = new ListNode(val);
        ListNode temp = A;
        for(int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return A;
    }

    public static ListNode insertAtAnyPosition(ListNode A, int B, int C) {
        ListNode newNode = new ListNode(B);
        ListNode temp = A;
        if(C == 0 || temp == null) {  // temp == null -> it will check there is no element in LinkedList
            newNode.next = temp;
            A = newNode;
            return A;
        }
        for(int i = 0; i < C - 1; i++) {
            if(temp.next == null) {  // when position is given more the LinkedList size
                break;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return A;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        // ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // node1.next = node2;
        // node2.next = node3;
        // node1 = insertAtFirstPos(node1, 0);
        // node1 = insertAtLastPos(node1, 4);
        // node1 = insertAtIndex(node1, 9, 2);
        solve(node1);
        node1 = insertAtAnyPosition(node1, 5, 7);
        solve(node1);
    }   
}
