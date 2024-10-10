class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Q3_LinkedList {
    static ListNode head = null;

    public static void insert_node(int position, int value) {
        ListNode newNode = new ListNode(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode temp = head;
            int currentPosition = 1;
            while (head != null && currentPosition < position - 1) {
                temp = temp.next;
                currentPosition++;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

    }

    public static void delete_node(int position) {
        // @params position, integer
        if (head == null){
            return;
        }
       
        if(position == 1) {
            head = head.next;
        }
        else {
            ListNode temp = head;
            int currentPosition = 1;
            while (temp != null && currentPosition < position - 1) {
                temp = temp.next;
                currentPosition++;
            }
            if(temp != null && temp.next != null){
                temp.next = temp.next.next;
            }
        }
    }


    public static void print_ll() {
        // Output each element followed by a space
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        insert_node(1, 23);
        insert_node(2, 26);
        insert_node(3, 28);
        print_ll();
        System.out.println("-----------");
        insert_node(2, 70);
        print_ll();
        delete_node(1);
        System.out.println("delted");
        print_ll();
    }
}
