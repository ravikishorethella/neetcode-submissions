class MinStack {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(mainStack.isEmpty()) return;
        int top = mainStack.pop();
        if(top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
