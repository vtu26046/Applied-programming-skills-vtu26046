import java.util.Stack;

class BrowserHistory {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String current;

    // Constructor
    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        current = homepage;
    }

    // Visit a new URL
    public void visit(String url) {
        backStack.push(current);   // Save current page
        current = url;             // Move to new page
        forwardStack.clear();      // Clear forward history
    }

    // Move back
    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
            steps--;
        }
        return current;
    }

    // Move forward
    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
            steps--;
        }
        return current;
    }
}