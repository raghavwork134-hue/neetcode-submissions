class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        st.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        
        if(minStack.isEmpty()) return;
        int top = st.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }

    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
