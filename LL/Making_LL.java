package LL;

public class Making_LL {
    private Node head;
    private Node tail;
    private int size;

    public Making_LL() {
        this.size = 0;
    }
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value; 
            this.next = next;
        }
    }
    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next!=null){
          temp=temp.next;
        }
        temp.next = node;

    }

   public void deleteParticular(int key) {

            // Case 1: Empty list
            if (head == null) {
                System.out.println("List empty");
                return;
            }

            // Case 2: Head node delete
            if (head.value == key) {
                head = head.next;
                return;
            }

            // Case 3: Middle or last node
            Node prev = null;
            Node curr = head;

            while (curr != null && curr.value != key) {
                prev = curr;
                curr = curr.next;
            }

            // Value not found
            if (curr == null) {
                System.out.println("Element not found");
                return;
            }

            // Actual deletion
            prev.next = curr.next;

            size--;
        }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


}
