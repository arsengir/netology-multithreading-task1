public class Main {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group");

        System.out.println("Создаю потоки ...");
        Thread thread1 = new MyThread(group, "1");
        Thread thread2 = new MyThread(group, "2");
        Thread thread3 = new MyThread(group, "3");
        Thread thread4 = new MyThread(group, "4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException ignored) {

        }

        System.out.println("Завершаю все потоки");
        group.interrupt();
    }
}
