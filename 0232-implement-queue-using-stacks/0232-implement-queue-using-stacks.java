import java.util.Stack;

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    // Constructor
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Push element to back
    public void push(int x) {
        inStack.push(x);
    }

    // Remove element from front
    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }

    // Get front element
    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }

    // Check if empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Helper function
    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
