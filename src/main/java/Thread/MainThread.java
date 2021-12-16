package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
    public static void main(String[] args) {
/*        Thread thread = new TestThread();
        Thread thread1 = new TestThread();
        Thread thread2 = new TestThread();

        thread.setDaemon(true);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);*/
/*        thread.run();
        thread1.run();*/

/*        thread.start();
        System.out.println(thread.getName());
        thread.setName("Fus dep trai thread");
        System.out.println(thread.getName());*/

        /*
            join will make that thread execute all its task
            If pass time for join -> that thread will execute in that time. After end that time and still not finish
            another thread can start to run
         */


/*        thread1.start();
        thread2.start();
        System.out.println("After run");*/


        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}
