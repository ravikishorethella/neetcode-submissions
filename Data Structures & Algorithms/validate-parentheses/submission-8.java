class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        // Map.of() creates an immutable collection
        // we do not want our program to modify this
        Map<Character, Character> map = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
        );

        for(char c: s.toCharArray()) {
            // If the character is a closing bracket (it exists as a key in our map)
            if(map.containsKey(c)) {
                // check if stack is empty or the char matches with pop value
                if(stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // We push only the opening brackets to stack
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

// Space and Time complexity is O(n)
