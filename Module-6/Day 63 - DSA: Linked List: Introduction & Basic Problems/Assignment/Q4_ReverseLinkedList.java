
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    } 
}
public class Q4_ReverseLinkedList {

    public static void printLinkedList(ListNode A) {
        ListNode temp = A;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode A) {
        ListNode currNode = A;
        ListNode prev = null;

        while(currNode != null) {
            ListNode next = currNode.next;
            currNode.next=  prev;
            prev = currNode;
            currNode = next;
        }
        return prev;
    }

    public static boolean isPalin(ListNode A) {
        if(A == null || A.next == null) {
            return 1;  // A single node or empty list is always a palindrome
        }

        // Step 1:  find the middle of the linked list
        ListNode fast = A, slow = A;
        while(slow.next != null && fast.next != null) {
            slow=  slow.next;
            fast = fast.next.next;
        }


        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = A;
        
        int palindrome = 1;
        while (secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                palindrome = 0;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return palindrome;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=  node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // printLinkedList(node1);
        System.out.println(isPalin(node1));
        // node1 = reverseList(node1);
        // printLinkedList(node1);

    }
}
