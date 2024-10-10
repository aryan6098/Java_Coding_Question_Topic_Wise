class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Q2_MergeTwoSortedLists {


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

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode current = null;
        ListNode ans = null;
        if (A.val < B.val) {
            current = A;
            ans = A;
            A = A.next;
        } else {
            current = B;
            ans = B;
            B = B.next;
        }

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

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode head1 = null;
        ListNode head2 = null;
        int[] arr = { 5, 8, 20 };
        int[] arr1 = { 4, 11, 15 };
        head1 = insertMultiple(head1, arr);
        head2 = insertMultiple(head2, arr1);
        ListNode ans = mergeTwoLists(head1, head2);
        printLinkedList(ans);

    }
}
