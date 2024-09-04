
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x ){
        val = x;
        next = null;
    }
}
public class Q1_RemoveNthNodefromListEnd {

    public static ListNode removeNthFromEnd(ListNode A, int B) {
    }
    public static void printLinkedList(ListNode A) {
        ListNode temp  = A;
        while(temp != null) {
            System.out.print(temp.val +" ");
            temp = temp.next; 
        }
        System.out.println();
    }

    public static ListNode solve(ListNode A, int B) {

        
        ListNode temp = A;
        if(B == 0) {
           temp = temp.next;
           return temp;
        }
        for(int  i = 0; i < B - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return A;
    }

    public static int findIndex(ListNode A, int B) {
        ListNode temp  = A;
        int idx = 0;
        while(temp != null) {
            idx++;
            temp = temp.next; 
        }
        return (idx - B);
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // printLinkedList(node1);
        // node1 = solve(node1, 4);
        // printLinkedList(node1);

        System.out.println(findIndex(node1, 2));
    }
}