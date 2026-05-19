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

    private Node sentinel;
    private int size;

    public LinkedList() {
        this.sentinel = new Node(-1);
        this.size = 0;
    }

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

    public void insertHead(int val) {
        insertAtIndex(0, val);
    }

    public void insertTail(int val) {
        insertAtIndex(size, val);
    }

    public void insertAtIndex(int index, int val) {
        // if index > size then we cannot add
        if(index > size) {
            return;
        }

        // considering the negative index as index = 0
        if(index < 0) {
            index = 0;
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

    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            return false;
        }

        // find the predecessor of the node
        Node pred = sentinel;
        for(int i = 0; i < index; i++) {
            pred = pred.next;
        }

        // delete by skipping the target node
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
