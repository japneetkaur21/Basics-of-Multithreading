import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable{
    int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread name::"+Thread.currentThread().getName()+" Start :"+id);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread name::"+Thread.currentThread().getName()+" End :"+id);
    }
}

public class Increase_concurrency_with_thread_pools_using_newCachedThreadPool_and_newFixedThreadPool {
    public static void main(String[] args) {

//    ExecutorService executorService= Executors.newFixedThreadPool(3);
        ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i = 0; i <= 30; i++) {
            executorService.submit(new Process(i));
        }
        executorService.shutdown();
    }
}

