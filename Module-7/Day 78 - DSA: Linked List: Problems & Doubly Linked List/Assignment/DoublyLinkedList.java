/*
 * 
 */
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int x) {
        this.val = x;
        this.next = null;
        this.prev = null;
    }
}

// class NodePair {
// ListNode head;
// ListNode tail;
// NodePair(ListNode head, ListNode tail) {
// this.head = head;
// this.tail = tail;
// }
// }

public class DoublyLinkedList {

    public static ListNode insert(ListNode head, ListNode tail, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        return tail;
    }

    public static ListNode addElementInFront(int x, ListNode head, ListNode tail) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        return head;  
    }

    public static ListNode addELementInBack(int x, ListNode head, ListNode tail) {
        ListNode newNode = new ListNode(x);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return tail;
    }

    public static ListNode addElementInMiddle(int x, ListNode head, ListNode tail) {
        ListNode newNode = new ListNode(x);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode nextNode = slow.next.next;
            slow.next = newNode;
            newNode.prev = slow;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        return head;
    }

    public static ListNode deleteNodeFormFront(ListNode head) {
        if(head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    public static ListNode deleteNodeFormLast(ListNode tail) {
        tail = tail.prev;
        tail.next = null;
        return tail;
    }

    public static ListNode deleteNodeFromMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prevListNode = slow.prev;
        ListNode nextNode = slow.next;
        slow.prev = null;
        slow.next = null;
        prevListNode.next = nextNode;
        nextNode.prev = prevListNode;
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode tail = null;
        tail = insert(head, tail, 1);
        if (head == null) {
            head = tail;
        }
        tail = insert(head, tail, 3);
        tail = insert(head, tail, 5);
        tail = insert(head, tail, 6);
        print(head);
        head = addElementInFront(10, head, tail);
        print(head);
        tail = addELementInBack(26, head, tail);
        // tail = addELementInBack(12, head, tail);
        print(head);
       head =  addElementInMiddle(13, head, tail);
       print(head);
       head = deleteNodeFormFront(head);
       print(head);
       tail = deleteNodeFormLast(tail);
       print(head);
       head = deleteNodeFromMid(head);
       print(head);
    }
}
