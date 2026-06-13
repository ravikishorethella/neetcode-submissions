class MedianFinder {

    private PriorityQueue<Integer> rightMinHeap;
    private PriorityQueue<Integer> leftMaxHeap;

    public MedianFinder() {
        this.rightMinHeap = new PriorityQueue<>();
        this.leftMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        // by default we add to the leftMaxHeap
        leftMaxHeap.offer(num);

        // fixing the order rule
        // if max of left side is bigger than the min of right side
        if(!leftMaxHeap.isEmpty() && !rightMinHeap.isEmpty() &&
        leftMaxHeap.peek() > rightMinHeap.peek()) {
            rightMinHeap.offer(leftMaxHeap.poll());
        }

        // we need to balance it based on the size
        if(leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        } else if(rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        // two cases

        // case 1 - odd number of elements
        if(leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        }

        // case 2
        return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
    }
}
