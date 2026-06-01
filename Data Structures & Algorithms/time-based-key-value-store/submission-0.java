class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String result = "";

        if(!map.containsKey(key)) {
            return result;
        } else {
            List<Pair> pair = map.get(key);

            // this is a list and there are some pairs inside this
            int left = 0;
            int right = pair.size() - 1;

            while(left <= right) {
                int mid = (left + right) >>> 1;

                if(pair.get(mid).timestamp <= timestamp) {
                    result = pair.get(mid).value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
