// Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
// Memory Usage: 39.6 MB, less than 56.03% of Java online submissions for Implement Stack using Queues.

class MyStack {
    List<Integer> stack;
    
    public MyStack() {
        stack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public int pop() {
        Integer result = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return result;
    }
    
    public int top() {
        return stack.get(stack.size() -1);
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */