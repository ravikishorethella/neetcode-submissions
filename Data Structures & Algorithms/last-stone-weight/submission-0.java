class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // offer elements to heap
        for(int stone: stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int topHeavy = maxHeap.poll();
            int secondHeavy = maxHeap.poll();

            if(topHeavy > secondHeavy) {
                maxHeap.offer(topHeavy - secondHeavy);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
