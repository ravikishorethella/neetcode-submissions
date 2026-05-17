class Solution {
    public int calPoints(String[] operations) {

        // arraylist to store the nums from the ops
        Stack<Integer> stack = new Stack<>();

        // running sum 
        int totalSum = 0;

        // enhanced loop and updating the totalSum based on each operation 
        for (String operation: operations) {
            if(operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                totalSum += newTop;
            } else if (operation.equals("C")) {
                totalSum -= stack.pop();
            } else if(operation.equals("D")) {
                stack.push(stack.peek() * 2);
                totalSum += stack.peek();
            } else {
                stack.push(Integer.parseInt(operation));
                totalSum += stack.peek();
            }
        }

        return totalSum;
    }
}