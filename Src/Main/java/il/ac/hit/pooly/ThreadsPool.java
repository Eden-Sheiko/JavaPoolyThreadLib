// Eden Sheiko 318460433
// Lital Kraft 314806647

package il.ac.hit.pooly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * The ThreadsPool class represents a thread pool that handles tasks with priority.
 * It uses an ExecutorService for executing tasks and a PriorityBlockingQueue to store tasks by priority.
 * (High priority - first)
 */
public class ThreadsPool {
    private ExecutorService priorityTaskPoolExecutor;
    private PriorityBlockingQueue<Task> priorityQueue;

    /**
     * Constructs a new ThreadsPool with the specified pool size.
     * @param poolSize The number of threads in the pool.
     * @throws ThreadPoolException if the pool size is invalid (less than 1).
     */
    public ThreadsPool(int poolSize) throws ThreadPoolException {
        // Check if the pool size is valid
        if (poolSize < 1)
            throw new ThreadPoolException("Invalid pool size");

        // Create thread pool executor with size: poolSize
        priorityTaskPoolExecutor = Executors.newFixedThreadPool(poolSize);

        // Create a priority blocking queue to store tasks by priority
        priorityQueue = new PriorityBlockingQueue<>();
    }

    /**
     * Submits a task to the thread pool for execution.
     * The task is added to the priority queue and executed by a thread from the pool.
     * @param task The task to be submitted.
     */
    public void submit(Task task) {
        // Add task to the priority queue
        priorityQueue.add(task);

        // Submit a job to the thread pool executor
        priorityTaskPoolExecutor.submit(() -> {
            try {
                // Retrieve a task from priority queue & performing the task
                Task queuedTask = priorityQueue.take();
                queuedTask.perform();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    /**
     * Shuts down the thread pool.
     * It stops accepting new tasks, waits for all tasks to complete,
     * and assign null to priorityQueue & priorityTaskPoolExecutor
     * for the garbage collector
     * @throws InterruptedException if the shutdown process is interrupted.
     */
    public void shutdown() throws InterruptedException {
        priorityTaskPoolExecutor.shutdown();
        priorityTaskPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        priorityQueue = null;
        priorityTaskPoolExecutor = null;
    }
}



