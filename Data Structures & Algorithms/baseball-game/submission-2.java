class Solution {
    public int calPoints(String[] operations) {

        ArrayList<Integer> nums = new ArrayList<>();
        
        int totalSum = 0; 

        for (String operation : operations) {
            switch (operation) {
                case "+":
                    // Get the last two elements using their index positions
                    int last = nums.get(nums.size() - 1);
                    int secondLast = nums.get(nums.size() - 2);
                    
                    int plusResult = last + secondLast;
                    nums.add(plusResult);
                    totalSum += plusResult;
                    break;
                    
                case "C":
                    if (!nums.isEmpty()) {
                        // removeLast() works exactly like stack.pop()
                        totalSum -= nums.removeLast();
                    }
                    break;
                    
                case "D":
                    if (!nums.isEmpty()) {
                        // nums.getLast() works exactly like stack.peek()
                        int doubledResult = nums.getLast() * 2;
                        nums.add(doubledResult);
                        totalSum += doubledResult;
                    }
                    break;
                    
                default:
                    int val = Integer.parseInt(operation);
                    nums.add(val);
                    totalSum += val;
                    break;
            }
        }
        
        return totalSum;
    }
}