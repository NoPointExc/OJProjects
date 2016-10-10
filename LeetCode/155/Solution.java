public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minVal;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minVal = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minVal.isEmpty() || minVal.peek() >= x){
            minVal.push(x);
        }else{
            minVal.push(minVal.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minVal.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        minVal.peek();
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