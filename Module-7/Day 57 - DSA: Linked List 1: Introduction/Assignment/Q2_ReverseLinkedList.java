/*
 * Q2. Reverse Linked List

 */

import java.util.List;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
public class Q2_ReverseLinkedList {

    public static ListNode insert(ListNode A, int x){
        ListNode newNode = new ListNode(x);
        if(A == null) {
            A = newNode;
            return A;
        }
        ListNode temp = A;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return A;
    }

    public static void print(ListNode A) {
        while (A != null) {
            System.out.print(A.val +" ");
            A = A.next;
        }
    }

    public static ListNode reverseList(ListNode A) {
        if(A == null || A.next == null) {
            return A;
        } 
        ListNode curr = A;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=  next;
        }
        A =  prev;
        return A;

    }
    public static void main(String[] args) {
        Q2_ReverseLinkedList obj = new Q2_ReverseLinkedList();
        ListNode head = new ListNode(2);
        obj.insert(head, 1);
        obj.insert(head, 2);
        obj.insert(head, 3);
        print(head);
        System.out.println();
        head = reverseList(head);
        print(head);
    }
}
