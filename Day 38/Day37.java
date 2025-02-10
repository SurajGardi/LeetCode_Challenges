import java.util.Stack;

public class Day37 {
    // Main stack to store all elements
    private Stack<Integer> st;
    
    // Auxiliary stack to keep track of minimum elements
    private Stack<Integer> min;

    // Constructor to initialize the stacks
    public Day37() {
        st = new Stack<>();
        min = new Stack<>();
    }

    // Pushes an element onto the stack
    public void push(int val) {
        // If stack is empty or current value is less than or equal to min, push to min stack
        if (st.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
        st.push(val);
    }

    // Removes the element from the top of the stack
    public void pop() {
        int removedElement = st.pop();
        // If the removed element is the minimum, pop from min stack as well
        if (removedElement == min.peek()) {
            min.pop();
        }
    }

    // Returns the top element of the stack
    public int top() {
        return st.peek();
    }

    // Retrieves the minimum element in the stack
    public int getMin() {
        return min.peek();
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Day37 minStack = new Day37();
        
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        System.out.println("Current Minimum: " + minStack.getMin()); // Output: -3

        minStack.pop();
        
        System.out.println("Top Element: " + minStack.top());       // Output: 0
        System.out.println("Current Minimum: " + minStack.getMin()); // Output: -2
    }
}
