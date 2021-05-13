import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private final int numberRepetitions;

    public MyCallable(int numberRepetitions) {
        this.numberRepetitions = numberRepetitions;
    }

    @Override
    public Integer call() throws Exception {
        int a = 0;
        while (a < numberRepetitions) {
            Thread.sleep(2500);
            System.out.printf("Я поток %s. Всем привет!\n", Thread.currentThread().getName());
            a++;
        }
        return a;
    }
}
