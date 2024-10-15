/*
 * Q3. Palindrome List

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
  
public class Q3_PalindromeList {
    public static ListNode insert(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if(head == null) {
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
        if(head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val +" ");
            head = head.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
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

    public static int lPalin(ListNode A) {
        ListNode fast = A, slow = A;
        boolean isPalindrome = true;
        while(fast.next != null && fast.next.next!= null)  {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list1 = reverseList(slow.next);;
        slow.next = null;
        while (A != null && list1 != null) {
            if(A.val != list1.val) {
                isPalindrome = false;;
            }
            A = A.next;
            list1 = list1.next;
        }
        if(isPalindrome){
            return 1;
        }else{ 
            return 0;
        }
       
    }   


    public static void main(String[] args) {
        ListNode head = null;
        // head =  insert(head, 8);
        head = insert(head, 1);
        head = insert(head, 2);
        head =  insert(head, 3);
        head = insert(head, 2);
        head = insert(head, 1);

        // head =  insert(head, 7);
        
    //    printList(head);
       System.out.println(lPalin(head));
    }
}
