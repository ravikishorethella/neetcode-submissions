class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int num: map.keySet()) {
            int freq = map.get(num);

            // if no bucket
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // looping from backwards to get the highest 
        int[] result = new int[k];
        int resultIdx = 0;

        for(int i = buckets.length - 1; i >= 0; i--) {
            if(buckets[i] != null) {
                for(int num: buckets[i]) {
                    result[resultIdx] = num;
                    resultIdx++;

                    // if the result size is k
                    if(resultIdx == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
