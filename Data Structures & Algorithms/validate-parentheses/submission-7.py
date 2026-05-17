class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        store = {
            '{' : '}',
            '[' : ']',
            '(' : ')'
        }
        for char in s:
            if char in store:
                stack.append(store[char])
            elif len(stack) == 0 or char != stack.pop():
                    return False

        return len(stack) == 0

        