public class Create_and_run_a_thread_using_runnable_interface_and_thread_class implements Runnable{

        @Override
        public void run() {
            System.out.println("Running Runnable Thread");
        }


        public static void main(String[] args) {
            new Thread(new Create_and_run_a_thread_using_runnable_interface_and_thread_class())
                    .start();
        }
    }

