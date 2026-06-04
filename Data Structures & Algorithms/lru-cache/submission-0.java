class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        // initialize the head and tail
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        // connect the head and tail (dummy nodes)
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAtHead(Node node) {
        Node nextNode = head.next;
        Node curr = head;

        head.next = node;
        node.prev = curr;
        node.next = nextNode;
        nextNode.prev = node;

    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);

        remove(node);
        insertAtHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            remove(node);
            insertAtHead(node);
        } else {
            if(map.size() == capacity) {
                Node prevNode = tail.prev;
                map.remove(prevNode.key);

                remove(prevNode);
            } 

            Node node = new Node(key, value);
            map.put(key, node);
            insertAtHead(node);
        }
    }
}
