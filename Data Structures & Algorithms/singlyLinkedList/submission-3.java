class LinkedList {
    
    // Inner class to represent a node in the linked list
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node sentinel; // dummy head
    private Node tail; // dummy tail
    private int size;

    public LinkedList() {
        this.sentinel = new Node(-1); // dummy head
        this.tail = this.sentinel; // initially, tail is the sentinel
        this.size = 0;
    }

    // O(k) - k is the index
    public int get(int index) {
        // check whether the index is valid or not
        if(index < 0 || index >= size) {
            return -1;
        }

        // if valid index, start from sentinel.next
        Node current = sentinel.next;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    // O(1) operation
    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = sentinel.next;
        sentinel.next = newNode;
        // if the list was empty and the new node is also the tail
        if(tail == sentinel) {
            tail = newNode;
        }
        size++;
    }

    // append a node to the tail. This is now O(1) operation
    public void insertTail(int val) {
        Node newNode = new Node(val);
        tail.next = newNode; // link current tail to new node
        tail = newNode; // update the tail to newNode
        size++;
    }

    // O(k)
    public void insertAtIndex(int index, int val) {
        // if index > size then we cannot add
        if(index > size) {
            return;
        }

        // considering the negative index as index = 0
        if(index < 0) {
            index = 0;
        }

        if(index == size) {
            insertTail(val);
            return;
        }

        if(index == 0) {
            insertHead(val);
            return;
        }

        // find the predecessor of the node
        Node pred = sentinel;
        for(int i = 0; i < index; i++) {
            pred = pred.next;
        }

        // once the predecessor is found then it is a basic logic
        Node newNode = new Node(val);

        // insertion logic
        newNode.next = pred.next;
        pred.next = newNode;
        size++;
    }

    // Delete a node at a specific index - O(k)
    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            return false;
        }

        // find the predecessor of the node
        Node pred = sentinel;
        for(int i = 0; i < index; i++) {
            pred = pred.next;
        }

        // if we are deleting the tail, we must update the tail pointer
        if(pred.next == tail) {
            tail = pred;
        }

        // bypass the node to be deleted
        pred.next = pred.next.next;
        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        Node curr = this.sentinel.next;

        while(curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }

        return res;
    }
}
