package il.ac.hit.pooly;

import java.util.concurrent.*;

public class ThreadsPool {
    private final ExecutorService executor;
    private final PriorityBlockingQueue<Runnable> queue;

    public ThreadsPool(int nThreads) {
        queue = new PriorityBlockingQueue<>();
        executor = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, queue);
    }

    public void submit(Task task) {
        executor.submit(new PriorityTask(task));
    }
}
