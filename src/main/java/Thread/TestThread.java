package Thread;

public class TestThread extends Thread {
    @Override
    public void run() {
/*        for(int i=1;i<5;i++){
            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
            System.out.println(Thread.currentThread().getName() + " is running");
        }*/

        if (Thread.currentThread().isDaemon()) {
            System.out.println(Thread.currentThread().getName() + " is daemon");
            return;
        }
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
