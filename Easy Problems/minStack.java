class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty() || x <= minstack.peek())
            minstack.push(x);
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        int x = stack.pop();
        if(minstack.isEmpty())
            return;
        if(x == minstack.peek())
            minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
