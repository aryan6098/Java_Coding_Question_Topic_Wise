/*
 * Q4. Middle element of linked list
Problem Description

Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints

1 <= length of the linked list <= 100000

1 <= Node value <= 109


Input Format

The only argument given head pointer of linked list.


Output Format

Return the middle element of the linked list.


Example Input

Input 1:

 1 -> 2 -> 3 -> 4 -> 5
Input 2:

 1 -> 5 -> 6 -> 2 -> 3 -> 4


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 The middle element is 3.
Explanation 2:

 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.

 */
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Q4_MiddleElementOfLinkedList {

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

        for(int val: values) {
            head = insert(head, val);
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static int solve(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while(fast != null && fast.next != null) {
            fast =  fast.next.next;
            slow =  slow.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = null;
        Q4_MiddleElementOfLinkedList obj = new Q4_MiddleElementOfLinkedList();
        int arr[] = {1, 2, 3, 4, 5, 6};
        head = obj.insertMultiple(head, arr);
        printLinkedList(head);
        // head = obj.insert(head, 1);
        // head = obj.insert(head, 5);
        // head = obj.insert(head, 6);
        // head = obj.insert(head, 2);
        // head = obj.insert(head, 3);
        // head = obj.insert(head, 4);
        System.out.println("mid: " + solve(head));
        
    }
}
