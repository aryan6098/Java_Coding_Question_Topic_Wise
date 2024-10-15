/*
 * Q2. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
 */

import java.util.HashMap;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key,int x) {
        this.key = key;
        this.val = x;
        this.next = null;
        this.prev = null;
    }
}

public class Q2_LRUCache {

    public static HashMap<Integer, ListNode> hashMap = new HashMap<>();
    private static int capacity;
    private static ListNode head;
    private static ListNode tail;

    public Q2_LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public static void insertBack(ListNode newNode) {
        if (tail == null) { // List is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    public static void deleteNode(ListNode node) {
        if (node == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        ;
        ListNode node = hashMap.get(key);
        deleteNode(node);
        insertBack(node);
        return node.val;
    }

    public static void set(int key, int value) {
        if(hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.val = value;
            deleteNode(node);
            insertBack(node);
        }else {
            if(hashMap.size() == capacity) {
                hashMap.remove(head.key);
                deleteNode(head);
            }

            ListNode newNode = new ListNode(key, value);
            insertBack(newNode);
            hashMap.put(key, newNode);
        }
    }

    public void printCache() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.key + ":" + temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Q2_LRUCache lruCache = new Q2_LRUCache(2);
        lruCache.set(1, 10);
        lruCache.set(5, 12);
        System.out.println(lruCache.get(5)); // returns 12
        System.out.println(lruCache.get(1)); // returns 10
        System.out.println(lruCache.get(10)); // returns -1
        lruCache.set(6, 14); // evicts key 5
        System.out.println(lruCache.get(5)); // returns -1

    }
}
