class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        // looping through each character
        for(char ch: s.toCharArray()) {
            // for every opening bracket, we push the respective closed bracket into the stack
            if(ch == '(') {
                stack.push(')');
            } else if(ch == '[') {
                stack.push(']');
            } else if(ch == '{') {
                stack.push('}');
            } else {
                if(stack.isEmpty() || stack.peek() != ch) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

// Space and Time complexity is O(n)
