class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}
public class DeleteListNode {

    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
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



    public static ListNode deleteDuplicateNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode hNode = head;
        while(hNode != null && hNode.next != null) {
            if(hNode.val == hNode.next.val) {
                ListNode nextNode = hNode.next.next;
                hNode.next = nextNode;
            }else {
                hNode = hNode.next;
            }
        }
        
        return head;
    }


    public static void printList(ListNode head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head,3);
        head = insert(head,3);
        head = insert(head,4);
        head = insert(head,5);
        head =  deleteDuplicateNode(head);
        printList(head);
    }


}
