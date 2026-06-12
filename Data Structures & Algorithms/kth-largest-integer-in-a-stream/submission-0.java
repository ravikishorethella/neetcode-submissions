class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(); // default is min-Heap in java

        for(int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // offering the val to minHeap
        minHeap.offer(val);

        // check if the size is > k
        if(minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
