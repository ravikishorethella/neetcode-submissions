class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {

            // building the count array
            int[] counts = new int[26];
            for(char ch: s.toCharArray()) {
                counts[ch - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int count: counts) {
                sb.append(count).append("#");
            }

            String mapKey = sb.toString();

            // check if mapKey is already present or not
            // if(map.containsKey(mapKey)) {
            //     map.get(mapKey).add(s);
            // } else {
            //     map.put(mapKey, new ArrayList<>());
            // }

            // newer java code
            map.computeIfAbsent(mapKey, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
