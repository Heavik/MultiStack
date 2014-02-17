
public class Stack {
    private static final int EMPTY_STACK = -1;
    private final int MAX_VALUE;
    private int[] stack;
    private int stackTop = EMPTY_STACK;

    public Stack(int capacity) {
        stack = new int[capacity];
        MAX_VALUE = capacity;
    }

    public void push(int value) {
        stack[++stackTop] = value;
    }

    public int pop() {
        return stack[stackTop--];
    }

    public int getStackTop() {
        return stackTop;
    }

    public int peek() {
        return stack[stackTop];
    }

    public boolean isStackEmpty() {
        return stackTop == EMPTY_STACK;
    }

    public boolean isStackFull() {
        return stackTop == (MAX_VALUE - 1);
    }
}
