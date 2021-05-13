import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Callable<Integer>> myCallables = new ArrayList<Callable<Integer>>(){{
                add(new MyCallable(10));
                add(new MyCallable(5));
                add(new MyCallable(8));
                add(new MyCallable(9));}};

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //Выполнение всех задач
        final List<Future<Integer>> tasks = threadPool.invokeAll(myCallables);
        for (Future<Integer> task : tasks) {
            System.out.println("Результат задачи: " + task.get());
        }

        //Выполнение одной из задач
        final Integer taskAny = threadPool.invokeAny(myCallables);
        System.out.println("Результат задачи: " + taskAny);

        threadPool.shutdown();

    }
}
