class NumberThread extends Thread {
    NumberThread(String name) { super(name); }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " prints " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
        System.out.println(getName() + " finished");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NumberThread t1 = new NumberThread("Thread-A");
        NumberThread t2 = new NumberThread("Thread-B");
        NumberThread t3 = new NumberThread("Thread-C");

        System.out.println("State after creation : " + t1.getState());   // NEW
        t1.start();
        t2.start();
        t3.start();
        System.out.println("State after start()  : " + t1.getState());   // RUNNABLE
        Thread.sleep(100);
        System.out.println("State while sleeping : " + t1.getState());   // TIMED_WAITING

        t1.join();
        t2.join();
        t3.join();
        System.out.println("State after finish  : " + t1.getState());   // TERMINATED
        System.out.println("All threads completed.");
    }
}
