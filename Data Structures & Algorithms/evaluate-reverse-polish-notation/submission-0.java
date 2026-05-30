class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token: tokens) {
            int b;
            int a;

            if (token.equals("+")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else {
                // It must be a number! Convert it and push to stack
                int number = Integer.parseInt(token);
                stack.push(number);
            } 
        }
        return stack.peek();
    }
}
