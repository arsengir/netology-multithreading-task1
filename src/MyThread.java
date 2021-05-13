public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException err) {
                return;
            }
            System.out.printf("Я поток %s. Всем привет!\n", Thread.currentThread().getName());
        }
    }
}
