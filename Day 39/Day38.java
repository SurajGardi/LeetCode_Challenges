import java.util.LinkedList;
import java.util.Queue;

public class Day38 {
    // Two queues to simulate stack behavior
    private Queue<Integer> mainQueue;
    private Queue<Integer> helperQueue;

    // Constructor to initialize the queues
    public Day38() {
        mainQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    // Pushes element x onto the stack
    public void push(int x) {
        // Move all elements from mainQueue to helperQueue
        while (!mainQueue.isEmpty()) {
            helperQueue.add(mainQueue.remove());
        }

        // Add the new element to mainQueue
        mainQueue.add(x);

        // Move all elements back from helperQueue to mainQueue
        while (!helperQueue.isEmpty()) {
            mainQueue.add(helperQueue.remove());
        }
    }

    // Removes the element on the top of the stack and returns it
    public int pop() {
        return mainQueue.remove();
    }

    // Returns the element on the top of the stack
    public int top() {
        return mainQueue.peek();
    }

    // Returns true if the stack is empty, false otherwise
    public boolean empty() {
        return mainQueue.isEmpty();
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        Day38 myStack = new Day38();

        // Push elements onto the stack
        myStack.push(1);
        myStack.push(2);

        // Display the top element
        System.out.println("Top element: " + myStack.top()); // Output: 2

        // Pop the top element
        System.out.println("Popped element: " + myStack.pop()); // Output: 2

        // Check if the stack is empty
        System.out.println("Is stack empty? " + myStack.empty()); // Output: false

        // Pop the last element
        System.out.println("Popped element: " + myStack.pop()); // Output: 1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + myStack.empty()); // Output: true
    }
}
