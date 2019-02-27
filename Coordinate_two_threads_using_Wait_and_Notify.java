public class Coordinate_two_threads_using_Wait_and_Notify {

    public void worker1(){
        synchronized (this) {
            System.out.println("Worker1 Started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker1 Done");
        }
    }



    public void worker4(){
        synchronized (this) {
            System.out.println("Worker 4 Started");
            System.out.println("Worker 4 Done");
            notify();
        }
    }

    public static void main(String[] args) {
        Coordinate_two_threads_using_Wait_and_Notify coordinate = new Coordinate_two_threads_using_Wait_and_Notify();
        new Thread(new Runnable() {
            @Override
            public void run() {
                coordinate.worker1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                coordinate.worker4();
            }
        }).start();
    }
}

