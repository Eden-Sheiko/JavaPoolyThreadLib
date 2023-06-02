package il.ac.hit.pooly;

public class PriorityTask implements Runnable, Comparable<PriorityTask> {
    private final Task task;

    public PriorityTask(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.perform();
    }

    @Override
    public int compareTo(PriorityTask otherTask) {
        return Integer.compare(otherTask.task.getPriority(), this.task.getPriority());
    }
}
