// Eden Sheiko 318460433
// Lital Kraft 314806647

import il.ac.hit.pooly.Task;

/**
 * The Job class implementing the Task interface and represents a task to be performed3
 */
public class Job implements Task {
    private int jobPriority;
    private boolean performed;

    /**
     * Constructs a new Job with the specified jobPriority.
     * @param jobPriority The priority level of the job.
     */
    public Job(int jobPriority) {
        setPriority(jobPriority);
        setPerformed(false);
    }

    @Override
    public void perform() {
        System.out.println("Performing job with priority: " + this.getPriority() + " on thread: "
                + Thread.currentThread().getName());
        try {
            // Simulate actual execution time
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setPerformed(true);
    }

    @Override
    public void setPriority(int priority) {
        this.jobPriority = priority;
    }

    @Override
    public int getPriority() {
        return jobPriority;
    }

    @Override
    public void setPerformed(boolean data) {
        this.performed = data;
    }

    @Override
    public boolean isPerformed() {
        return performed;
    }
}
