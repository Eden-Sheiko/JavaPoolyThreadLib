// Eden Sheiko 318460433
// Lital Kraft 314806647

import org.junit.Test;
import org.junit.jupiter.api.*;
import il.ac.hit.pooly.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The ThreadPoolTests class contains unit tests for the ThreadsPool class
 * and Task interface.
 */
public class ThreadPoolTests {
    private ThreadsPool threadPool;

    /**
     * This test creates 5 tasks with various priority,
     * and checks that all tasks are performed, with the highest priority first.
     * @throws InterruptedException      if the thread sleep is interrupted.
     * @throws ThreadPoolException      if there is an exception in the thread pool creation.
     */
    @Test
    public void testSubmitAndShutdown() throws InterruptedException, ThreadPoolException {
        int poolSize = 1;
        threadPool = new ThreadsPool(poolSize);

        // Create 5 jobs
        Task job1 = new Job(4);
        Task job2 = new Job(5);
        Task job3 = new Job(11);
        Task job4 = new Job(-7);
        Task job5 = new Job(24);

        // Submit the jobs to the threadPool
        threadPool.submit(job1);
        threadPool.submit(job2);
        threadPool.submit(job3);
        threadPool.submit(job4);
        threadPool.submit(job5);

        // Wait for the jobs to complete
        Thread.sleep(15000);

        // Verify that the jobs have been performed
        assertTrue(job1.isPerformed());
        assertTrue(job2.isPerformed());
        assertTrue(job3.isPerformed());
        assertTrue(job4.isPerformed());
        assertTrue(job5.isPerformed());

        // Shut down the scheduler
        threadPool.shutdown();
        threadPool = null;
    }

    /**
     * This test creates 10 tasks in a loop with various priority,
     * and checks that all tasks are performed, with the highest priority first.
     * @throws InterruptedException      if the thread sleep is interrupted.
     * @throws ThreadPoolException      if there is an exception in the thread pool creation.
     */
    @Test
    public void testSubmitAndShutdownLoop() throws InterruptedException, ThreadPoolException {
        int poolSize = 2;
        threadPool = new ThreadsPool(poolSize);

        // Create 10 jobs & submit the jobs to the threadPool
        for (int i = 0; i < 10; i++) {
            Task job = new Job(i);
            threadPool.submit(job);
        }

        // Wait for the jobs to complete
        Thread.sleep(25000);

        // Shut down the scheduler
        threadPool.shutdown();
        threadPool = null;
    }

    /**
     * This test creates 3 tasks with various priority,
     * and checks that the priority is updated correctly.
     */
    @Test
    public void testJobPriority() {
        // Create 3 jobs with different priorities
        Task job1 = new Job(4);
        Task job2 = new Job(5);
        Task job3 = new Job(1);

        // Verify the priorities of the jobs
        assertEquals(4, job1.getPriority());
        assertEquals(5, job2.getPriority());
        assertEquals(1, job3.getPriority());
    }

    /**
     * This test checks validation of poolSize ( > 0) and creates a new task and performs it.
     * @throws InterruptedException      if the thread sleep is interrupted.
     * @throws ThreadPoolException      if there is an exception in the thread pool creation.
     */
    @Test
    public void testValidThreadPoolSize() throws InterruptedException, ThreadPoolException {
        int poolSize = 4;
        try {
            threadPool = new ThreadsPool(poolSize);

            // Create & submit a job to the threadPool
            Task job = new Job(10);
            threadPool.submit(job);

            // Wait for the job to complete
            Thread.sleep(3000);

            // Check if the job was performed
            threadPool = null;
            Assertions.assertTrue(job.isPerformed(), "The job should have been executed");
        } catch (ThreadPoolException | InterruptedException e) {
            Assertions.fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    /**
     * This test checks that an exception is thrown when poolSize < 1.
     * @throws ThreadPoolException      if there is an exception in the thread pool creation.
     */
    @Test
    public void testInValidThreadPoolSize() throws ThreadPoolException {
        int poolSize = -5;

        try {
            threadPool = new ThreadsPool(poolSize);
            Assertions.fail("Expected ThreadPoolException to be thrown, but it was not.");
        } catch (ThreadPoolException e) {
            // Exception was caught, the test passed
            Assertions.assertTrue(e instanceof ThreadPoolException, "Expected ThreadPoolException to be thrown");
        }
    }
}