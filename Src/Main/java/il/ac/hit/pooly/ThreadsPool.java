package il.ac.hit.pooly;

import java.util.Comparator;
import java.util.concurrent.*;

public class ThreadsPool {
    private final ExecutorService executorService;

    public ThreadsPool(int num) {
        this.executorService = new ThreadPoolExecutor(
                num, num, 0L, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(10, new TaskComparator()));
    }

    public void submit(Task task) {
        executorService.submit(task::perform);
    }

    public void shutdown() {
        executorService.shutdown();
    }

    private class TaskComparator implements Comparator<Runnable> {
        @Override
        public int compare(Runnable r1, Runnable r2) {
            if (r1 instanceof Task && r2 instanceof Task) {
                return Integer.compare(((Task) r2).getPriority(), ((Task) r1).getPriority());
            }
            return 0;
        }
    }
}
