import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Use_synchronize_block_between_multiple_threads {

    int count;

    public void incrementCount() {
        synchronized(this) {
            this.count++;
        }
    }
    public void worker1() {
        for (int i=1;i<=100;i++){
            incrementCount();
        }
    }

    public void worker2() {
        for (int i=1;i<=100;i++){
            incrementCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Use_synchronize_method_between_multiple_threads synchronizeMethod = new Use_synchronize_method_between_multiple_threads();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeMethod.worker1();
                System.out.println("Worker 1 is working.");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeMethod.worker2();
                System.out.println("Worker 2 is working.");
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("The final count is : "+ synchronizeMethod.count);
    }

}
