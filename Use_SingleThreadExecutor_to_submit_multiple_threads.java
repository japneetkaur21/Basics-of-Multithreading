import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Use_SingleThreadExecutor_to_submit_multiple_threads {
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
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException e) {
//                    e.printStackTrace();
                        }
                        System.out.println("Thread 3");
                    }
                });

            } finally {
                executorService.shutdownNow();
            }

            System.out.println(executorService.isShutdown());
            System.out.println(executorService.isTerminated());
            System.out.println("End");
        }
    }

