class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Q3_RemoveLoopFromLinkedList {
    public static ListNode insert(ListNode head, int x) {
        ListNode newNde = new ListNode(x);
        if (head == null) {
            head = newNde;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNde;
        return head;
    }

    public static void printList(ListNode hNode) {
        if (hNode == null) {
            return;
        }
        while (hNode != null) {
            System.out.print(hNode.val + " ");
            hNode = hNode.next;
        }
    }

    public static ListNode removeCycleInList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode slow = A;
        ListNode fast = A;
        boolean isCyListNode = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCyListNode = true;
                break;
            }

        }
        if (!isCyListNode) {
            return A;
        }
        slow = A;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 8);
        printList(head);
        ListNode temp = head;
        ListNode loopNode = null;
        while (temp != null) {
            if (temp.val == 2) {
                loopNode = temp;
            }
            if (temp.next == null) {
                temp.next = loopNode;
                break;
            }
            temp = temp.next;
        }
        // System.out.println(hasCycleInList(head));
        head = removeCycleInList(head);
        printList(head);

    }
}
