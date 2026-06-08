class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor to initialize the queue
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0; // Tracks the actual number of elements
    }

    // Check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Insert an element at the rear of the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + value);
            return;
        }
        // Circular increment of rear pointer
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
        System.out.println("Enqueued: " + value);
    }

    // Remove and return the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Inside dequeue().");
            return -1; // Returning -1 to indicate error
        }
        int removedValue = queueArray[front];
        // Circular increment of front pointer
        front = (front + 1) % maxSize;
        currentSize--;
        return removedValue;
    }

    // Get the front element without removing it
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Inside front().");
            return -1;
        }
        return queueArray[front];
    }

    // Display all elements in the queue from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < currentSize; i++) {
            // Calculate the correct index in the circular array
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }
}

// Main class to test the queue implementation
public class QueueImplementation {
    public static void main(String[] args) {
        Queue myQueue = new Queue(5); // Create a queue of size 5

        // Testing isEmpty()
        System.out.println("Is queue empty? " + myQueue.isEmpty());

        // Testing enqueue()
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        
        myQueue.display();

        // Testing front()
        System.out.println("Front element: " + myQueue.front());

        // Testing dequeue()
        System.out.println("Dequeued element: " + myQueue.dequeue());
        System.out.println("Dequeued element: " + myQueue.dequeue());

        // Display queue after dequeuing
        myQueue.display();

        // Testing isFull() behavior with wrap-around
        myQueue.enqueue(50);
        myQueue.enqueue(60);
        myQueue.enqueue(70); // This will wrap around to indices freed by dequeue
        
        myQueue.display();
        System.out.println("Is queue full? " + myQueue.isFull());
    }
}