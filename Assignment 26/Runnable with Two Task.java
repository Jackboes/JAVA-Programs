class PrintTask implements Runnable {
    private String label;
    private int count;
    PrintTask(String label, int count) { this.label = label; this.count = count; }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(label + " -> step " + i + " [" + Thread.currentThread().getName() + "]");
            try { Thread.sleep(250); } catch (InterruptedException e) { }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PrintTask("Task-1 (Download)", 5), "Worker-1");
        Thread t2 = new Thread(new PrintTask("Task-2 (Upload)  ", 5), "Worker-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Both tasks completed.");
    }
}
