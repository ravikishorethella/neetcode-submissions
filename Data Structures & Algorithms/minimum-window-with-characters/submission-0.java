class Solution {
    public String minWindow(String s, String t) {
        int[] target = new int[128];
        int requiredMatches = 0;

        for(char ch: t.toCharArray()) {
            if(target[ch] == 0) {
                requiredMatches++;
            }
            target[ch] += 1;
        }

        int[] window = new int[128];
        int left = 0;
        int currentMatches = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window[rightChar]++;

            if(target[rightChar] > 0) {
                if(window[rightChar] == target[rightChar]) {
                    currentMatches++;
                }
            }

            // shrinking phase
            while(requiredMatches == currentMatches) {
                // 1. Record the best answer if current length is smaller than minLen
                if((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }
    
                // 2. Decrement leftChar from window array
                char leftChar = s.charAt(left);
                window[leftChar]--;


                // 3. If window count drops below target count, decrement currentMatches
                if(target[leftChar] > 0) {
                    if(window[leftChar] < target[leftChar]) {
                        currentMatches--;
                    }
                }

                // 4. Move left pointer forward
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE) {
            return "";
        } 
        return s.substring(startIndex, startIndex + minLen);
    }
}
