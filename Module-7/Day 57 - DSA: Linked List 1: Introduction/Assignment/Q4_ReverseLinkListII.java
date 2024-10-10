/*
 * Q4. Reverse Link List II
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints

1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format

The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format

Return a pointer to the head of the modified linked list.



Example Input

Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output

Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation

Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
 */

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Q4_ReverseLinkListII {

    public static ListNode insert(ListNode A, int x) {
        ListNode newNode = new ListNode(x);
        if (A == null) {
            A = newNode;
            return A;
        }
        ListNode temp = A;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return A;
    }

    public static void print_ll(ListNode head) {
        // Output each element followed by a space
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static ListNode reverListNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null) {
            return A;
        }
        ListNode curr = A;
        ListNode first = null;
        ListNode last = null;
        ListNode from = null;
        ListNode to = null;

        int count = 0;
        while (curr != null) {
            count += 1;
            if (count < B) {
                first = curr;
            }
            if (count == B) {
                from = curr;
            }
            if (count == C) {
                to = curr;
                last = to.next;
                break;
            }
            curr = curr.next;
        }
        to.next = null;
        reverListNode(from);
        if (first != null) {
            first.next = to;
        } else {
            A = to;
        }
        from.next = last;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head = insert(head, 2);
        head = insert(head, 3);
        // head = insert(head, 4);
        // head = insert(head, 5);
        // head = insert(head, 6);
        // head = insert(head, 8);
        head = reverseBetween(head, 2, 3);
        System.out.println("-------");
        print_ll(head);
    }
}
