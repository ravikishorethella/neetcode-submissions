class Solution {
    public int[] replaceElements(int[] arr) {
        // Approach 1
        /**
        I can try using nested loops to find the max value but it takes O(n**2)
        
        static void main() {
            int[] arr = {2, 4, 5, 3, 1, 2};

            for(int i = 0; i < arr.length; i++) {
                int max = 0;
                for(int j = i + 1; j < arr.length; j++) {
                    max = Math.max(max, arr[j]);
                }
                arr[i] = max;
            }

            arr[arr.length - 1] = -1;

            System.out.println(Arrays.toString(arr));
        }
        */

        // My current approach
        // Start from the end, take the max as last val and keep comparing to update the max val

        int max = arr[arr.length - 1];

        for(int i = arr.length - 1; i >= 0; i--) {
            if(i == arr.length - 1) {
                arr[i] = -1;
            } else {
                int currVal = arr[i];
                arr[i] = max;
                max = Math.max(currVal, max);
            }
        }
        return arr;
    }
}