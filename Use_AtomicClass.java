import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Use_AtomicClass {

    AtomicInteger count= new AtomicInteger();

    public void incrementCount() {
        synchronized (this) {
            count.incrementAndGet();
        }
    }

    public void worker1() {
        for (int i = 1; i <= 100; i++) {
            count.incrementAndGet();
        }
    }

    public void worker2() {
        for (int i = 1; i <= 100; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Use_AtomicClass synchronizeMethod = new Use_AtomicClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeMethod.worker1();
                System.out.println("Worker 1 is working");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeMethod.worker2();
                System.out.println("Worker 2 is working");
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("The count is: "+synchronizeMethod.count);
    }

}
