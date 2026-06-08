class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Push an element onto the top of the stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed: " + value);
    }

    // Remove and return the top element of the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Inside pop().");
            return -1; // Returning -1 to indicate error
        }
        int poppedValue = stackArray[top--];
        return poppedValue;
    }

    // Return the top element without removing it
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty! Inside peek().");
            return -1;
        }
        return stackArray[top];
    }

    // Display all elements in the stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}

// Main class to test the stack implementation
public class StackImplementation {
    public static void main(String[] args) {
        Stack myStack = new Stack(5); // Create a stack of size 5

        // Testing push()
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        
        // Testing display()
        myStack.display();

        // Testing peek()
        System.out.println("Top element (peek): " + myStack.peek());

        // Testing pop()
        System.out.println("Popped element: " + myStack.pop());
        System.out.println("Popped element: " + myStack.pop());

        // Display stack after popping
        myStack.display();
    }
}