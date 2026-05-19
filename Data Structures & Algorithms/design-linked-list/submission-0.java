class MyLinkedList {

    private static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    private final Node head; // sentinel head
    private final Node tail; // sentinel tail
    private int size;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail; // Empty list: head <-> tail 
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        // check if the index is valid
        if(index < 0 || index >= size) {
            return -1;
        }

        Node current;
        if(index < size / 2) {
            // closer to head; forward iteration
            current = head.next;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // closer to tail; backward iteration
            current = tail.prev;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            } 
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        // adding node at the head
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        // adding node at the tail
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        // check the index
        if(index < 0) {
            index = 0;
        }

        if(index > size) {
            return;
        }

        // finding the successor node, we need to insert before it
        Node succ;
        if(index < size / 2) {
            // traverse forward from head sentinel
            succ = head.next;
            for(int i = 0; i < index; i++) {
                succ = succ.next;
            }
        } else {
            // traverse backward from tail sentinel
            succ = tail;
            for(int i = size; i > index; i--) {
                succ = succ.prev;
            }
        }

        // the predecessor is the node before the successor
        Node pred = succ.prev;

        // insert the new Node between the successor and predecessor
        Node newNode = new Node(val);
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        // deleting at the ith index
        if(index < 0 || index >= size) {
            return;
        }

        // finding the node to delete
        Node toDelete;
        if(index < size / 2) {
            // traverse forward from head sentinel
            toDelete = head.next;
            for(int i = 0; i < index; i++) {
                toDelete = toDelete.next;
            }
        } else {
            toDelete = tail.prev;
            for(int i = size - 1; i > index; i--) {
                toDelete = toDelete.prev;
            }
        }

        // Unlink the node
        Node pred = toDelete.prev;
        Node succ = toDelete.next;
        pred.next = succ;
        succ.prev = pred;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */