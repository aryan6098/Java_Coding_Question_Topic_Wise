/*
 * Q1. Sort List
Problem Description

Sort a linked list, A in O(n log n) time.



Problem Constraints

0 <= |A| = 105



Input Format

The first and the only arugment of input contains a pointer to the head of the linked list, A.



Output Format

Return a pointer to the head of the sorted linked list.



Example Input

Input 1:

A = [3, 4, 2, 8]
Input 2:

A = [1]


Example Output

Output 1:

[2, 3, 4, 8]
Output 2:

[1]


Example Explanation

Explanation 1:

 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:

 The sorted form of [1] is [1].
 */

import java.util.List;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Q1_SortList {

    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static ListNode insertMultiple(ListNode head, int[] values) {

        for (int val : values) {
            head = insert(head, val);
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {

        ListNode current = null;
        ListNode ans = null;

        // Correct initialization for the head of the merged list
        if (A.val < B.val) {
            ans = A;
            A = A.next;
        } else {
            ans = B;
            B = B.next;
        }

        current = ans;

        while (A != null && B != null) {
            if (A.val < B.val) {
                current.next = A;
                current = A;
                A = A.next;
            } else {
                current.next = B;
                current = B;
                B = B.next;
            }
        }

        if (A != null) {
            current.next = A;
        } else {
            current.next = B;
        }
        return ans;
    }

    public static ListNode findMid(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode middle = findMid(A);
        ListNode nextToMid = middle.next;
        middle.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(nextToMid);
        return mergeTwoLists(left, right);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println("" + temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Q1_SortList obj = new Q1_SortList();
        int[] A = { 3, 4, 5, 2, 1, 8 };
        ListNode head = null;
        head = obj.insertMultiple(head, A);
        System.out.println();
        head = sortList(head);
        printList(head);
        // System.out.println("MID: " + findMid(head));
    }
}
