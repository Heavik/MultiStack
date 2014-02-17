import java.util.Random;

public class StackProcessor {
    private static final int STACK_CAPACITY = 10;
    private static final int NUMBER_OF_EXECUTIONS = 4;

    private boolean running = true;
    private Stack stack = new Stack(STACK_CAPACITY);
    private final Object lock = new Object();

    public void putToStack() throws InterruptedException {
        Random random = new Random();
        int executions = 0;
        while(running && executions != NUMBER_OF_EXECUTIONS) {
            synchronized (lock) {
                while (stack.isStackFull()) {
                    lock.wait();
                }
                stack.push(random.nextInt(100));
                System.out.println("Push to stack: " + stack.peek() + ", Stack TOP: " + stack.getStackTop());
                if(stack.isStackFull()) {
                    executions++;
                    lock.notify();
                }
            }
        }

    }

    public void getFromStack() throws InterruptedException {
        int executions = 0;
        while (running && executions != NUMBER_OF_EXECUTIONS) {
            synchronized (lock) {
                while (stack.isStackEmpty()) {
                    lock.wait();
                }
                System.out.println("Get from stack: " + stack.pop() + ", Stack TOP: " + stack.getStackTop());
                if(stack.isStackEmpty()) {
                    executions++;
                    lock.notify();
                }
            }
        }
    }

    public void interrupt() {
        running = false;
    }
}
