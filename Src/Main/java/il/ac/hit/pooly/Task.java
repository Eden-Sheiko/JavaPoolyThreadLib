// Eden Sheiko 318460433
// Lital Kraft 314806647

package il.ac.hit.pooly;

/**
 * The Task interface represents a task that can be performed, with various methods.
 */
public interface Task extends Comparable<Task> {
    /**
     * Performs the task.
     */
    void perform();

    /**
     * Sets the priority of the task.
     * @param priority The priority of the task.
     */
    void setPriority(int priority);

    /**
     * Gets the priority of the task.
     */
    int getPriority();

    /**
     * Compares the task with another task based on their priority.
     * Tasks will be arranged in descending order by priority.
     * @param other The other task to compare.
     */
    @Override
    default int compareTo(Task other) {
        return Integer.compare(other.getPriority(), this.getPriority());
    }

    /**
     * Checks if the task has been performed.
     */
    boolean isPerformed();

    /**
     * Sets the performed status of the task.
     * @param data The performed status of the task.
     */
    void setPerformed(boolean data);
}
