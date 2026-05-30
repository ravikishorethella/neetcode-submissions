class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token: tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                // perfoming the math based on the operation
                if (token.equals("+")) stack.push(a + b);
                else if (token.equals("-")) stack.push(a - b);
                else if (token.equals("*")) stack.push(a * b);
                else if (token.equals("/")) stack.push(a / b);

            } else {
                // It must be a number! Convert it and push to stack
                stack.push(Integer.parseInt(token));
            } 
        }
        return stack.peek();
    }
}
