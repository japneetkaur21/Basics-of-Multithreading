import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class use_IsShutDown_and_IsTerminated {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 3");
                }
            });
            System.out.println("isTerminated: "+executorService.isTerminated());
        } finally {
            executorService.shutdownNow();
        }

        System.out.println("isShutdown: "+executorService.isShutdown());
        System.out.println("isTerminated: "+executorService.isTerminated());
        System.out.println("End");
    }
}

