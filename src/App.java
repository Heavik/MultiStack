
public class App {
    public static void main(String[] args) throws InterruptedException {

        final StackProcessor processor =  new StackProcessor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.putToStack();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.getFromStack();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

       t1.start();
       t2.start();
     }
}
