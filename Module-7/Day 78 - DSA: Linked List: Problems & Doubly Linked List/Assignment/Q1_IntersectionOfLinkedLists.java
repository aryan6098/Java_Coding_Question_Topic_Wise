/*
 * Q1. Intersection of Linked Lists
Problem Description

Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
NOTE:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
The custom input to be given is different than the one explained in the examples. Please be careful.


Problem Constraints

0 <= |A|, |B| <= 106



Input Format

The first argument of input contains a pointer to the head of the linked list A.

The second argument of input contains a pointer to the head of the linked list B.



Output Format

Return a pointer to the node after which the linked list is intersecting.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = [6, 3, 4, 5]
Input 2:

 A = [1, 2, 3]
 B = [4, 5]


Example Output

Output 1:

 [3, 4, 5]
Output 2:

 []


Example Explanation

Explanation 1:

 In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point. 
Explanation 2:

 In the second example, the nodes don't have the same values, thus we can return None/Null. 

 */
public class Q1_IntersectionOfLinkedLists {

    public static ListNode insert(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
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

    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode A) {
        if (A == null) {
            return A;
        }
        ListNode curr = A;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A = prev;
        return A;
    }

    // public static ListNode getIntersectionNode(ListNode A, ListNode B) {
    // ListNode ptr1 = A;
    // ListNode ptr2 = B;
    // int length1 = 0;
    // int length2 = 0;
    // while (ptr1 != null) {
    // length1 += 1;
    // ptr1 = ptr1.next;
    // }
    // while (ptr2 != null) {
    // length2 += 1;
    // ptr2 = ptr2.next;
    // }
    // ptr1 = A;
    // ptr2 = B;
    // if (length1 > length2) {
    // int diff = length1 - length2;
    // while (diff > 0) {
    // ptr1 = ptr1.next;
    // diff--;
    // }
    // if (ptr1.equals(ptr2)) {
    // return ptr1;
    // }
    // } else {
    // int diff = length2 - length1;
    // while (diff > 0) {
    // ptr2 = ptr2.next;
    // diff--;
    // }
    // if (ptr2.equals(ptr1)) {
    // return ptr2;
    // }
    // }

    // while (ptr1 != null && ptr2 != null) {
    // if (ptr1.val == ptr2.val) {
    // return ptr1;
    // }
    // ptr1 = ptr1.next;
    // ptr2 = ptr2.next;
    // }

    // return null;
    // }

    // second method
    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        int countA = 0, countB = 0;
        ListNode ptr1 = A, ptr2 = B;
        if (A == null || B == null) {
            return null;
        }
        countA = countB = 1;
        while (ptr1.next != null) {
            countA++;
            ptr1 = ptr1.next;
        }
        while (ptr2.next != null) {
            countB++;
            ptr2 = ptr2.next;
        }
        // if(ptr1 != ptr2) {
        // return null;
        // }
        int diff = Math.abs(countA - countB);
        ptr1 = A;
        ptr2 = B;
        if (countA > countB) {
            while (diff > 0) {
                ptr1 = ptr1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                ptr2 = ptr2.next;
                diff--;
            }
        }
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        System.out.println(ptr1);
        return ptr2;

    }

    public static void main(String[] args) {
        ListNode head = null;
        // head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 9);
        head = insert(head, 10);
        head = insert(head, 12);
        // head = insert(head, 5);

        ListNode head2 = null;
        head2 = insert(head2, 7);
        head2 = insert(head2, 8);
        head2 = insert(head2, 9);
        head2 = insert(head2, 10);
        head2 = insert(head2, 12);

        head = getIntersectionNode(head, head2);
        printList(head);
    }}

;
