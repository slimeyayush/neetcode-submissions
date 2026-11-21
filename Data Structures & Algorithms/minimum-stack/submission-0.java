class MinStack {
      ArrayDeque<Integer> stack = new ArrayDeque<>();
        int minEle = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(val <= minEle) {
            stack.push(minEle);
            minEle = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        if(stack.pop() == minEle) {
            minEle = stack.pop();
        }
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return minEle;
    }
}
