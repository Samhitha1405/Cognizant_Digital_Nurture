import java.util.concurrent.*;
import java.util.*;
public class ExecutorDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            futures.add(pool.submit(() -> {
                System.out.println("Task " + n + " on " + Thread.currentThread().getName());
                return n * n;
            }));
        }
        for (Future<Integer> f : futures) {
            System.out.println("Result: " + f.get());
        }
        pool.shutdown();
    }
}