class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // min-heap for top k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(map::get)
        );

        // loop through the map keys and put it in heap
        for(int num: map.keySet()) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // print the final result
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
