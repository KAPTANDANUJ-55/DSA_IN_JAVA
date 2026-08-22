package LL;

public class DLL {

    private class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "-> ");
            current = current.next;
        }
        System.out.println("End");
    }

    public void displayReverse() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.value + " <- ");
            current = current.prev;
        }
        System.out.println("Start");
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("The DLL has nothing to delete");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    //    public void deleteParticular(int key) {
//
//        // Case 1: Empty list
//        if (head == null) {
//            System.out.println("List empty");
//            return;
//        }
//
//        if(tail==null){
//            System.out.println("List is empty");
//        }
//
//        // Case 2: Head node delete
//        if (head.value == key) {
//            deleteFirst();
//            return;
//        }
//        Node current = head;
//        while(current.value!=key){
//            current=current.next;
//        }
//        if(current==tail){
//            tail=current;
//        }
//        if(current==null){
//            System.out.println("List is empty");
//        }
//        current.prev.next= current.next;
//        current.next.prev=current.prev;
//        size--;
//
//
//    }}
    public void deleteParticular(int key) {

        // Case 1: Empty list
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        // Case 2: Head node delete
        if (head.value == key) {
            deleteFirst();
            return;
        }

        Node curr = head;

        // Traverse to find key
        while (curr != null && curr.value != key) {
            curr = curr.next;
        }

        // Value not found
        if (curr == null) {
            System.out.println("Element not found");
            return;
        }

        // Case 3: Tail node
        if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // Case 4: Middle node
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        size--;
    }
}


