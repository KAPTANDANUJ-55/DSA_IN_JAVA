package LL;

//class Node {
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//class CLL {
//    Node tail;
//
//    void deleteFirst() {
//
//        // empty list
//        if (tail == null) {
//            System.out.println("List empty");
//            return;
//        }
//
//        Node head = tail.next;
//
//        // only one node
//        if (head == tail) {
//            tail = null;
//            return;
//        }
//
//        // more than one node
//        tail.next = head.next;
//    }
//
//    void display() {
//        if (tail == null) return;
//
//        Node curr = tail.next; // head
//        do {
//            System.out.print(curr.data + " -> ");
//            curr = curr.next;
//        } while (curr != tail.next);
//
//        System.out.println("(back to head)");
//    }
//
//    void addFirst(int value) {
//        Node newNode = new Node(value);
//
//        // case 1: empty list
//        if (tail == null) {
//            tail = newNode;
//            tail.next = tail;   // circular banaya
//        }
//        // case 2: non-empty list
//        else {
//            newNode.next = tail.next; // new -> old head
//            tail.next = newNode;      // tail -> new head
//        }
//    }
//
//}


class Node {
    String process;
    Node next;

    Node(String process) {
        this.process = process;
    }
}

class CLL {
    private Node tail;

    // add process at end
    void addProcess(String p) {
        Node newNode = new Node(p);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // give CPU time to current process
    void executeProcess() {
        if (tail == null) return;

        Node head = tail.next;
        System.out.println("CPU executing: " + head.process);
    }

    // rotate for round-robin
    void rotate() {
        if (tail != null)
            tail = tail.next;
    }

    void display() {
        if (tail == null) return;

        Node curr = tail.next;
        do {
            System.out.print(curr.process + " → ");
            curr = curr.next;
        } while (curr != tail.next);

        System.out.println("(back to start)");
    }
}

