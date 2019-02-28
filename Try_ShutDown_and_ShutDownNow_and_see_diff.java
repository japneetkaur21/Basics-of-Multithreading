import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Try_ShutDown_and_ShutDownNow_and_see_diff {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread is interrupted");
                        break;
                    }
                }
            }
        });

       /* executor.shutdown();
        if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
            System.out.println("Running task not interrupted");
            System.exit(0);
        }
        System.out.println("Exiting normally");
        */

        executor.shutdownNow();
        if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
            System.out.println("Running task not interrupted");
            System.exit(0);
        }
        System.out.println("Exiting normally");

    }

}