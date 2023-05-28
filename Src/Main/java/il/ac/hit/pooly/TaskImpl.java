package il.ac.hit.pooly;

public class TaskImpl implements Task {
    private int priority;

    public TaskImpl(int priority){
        setPriority(priority);
    }

    public TaskImpl(){
        this(0);  // This calls the other constructor
    }

    @Override
    public void perform() {
        // Implementation of the perform method
        System.out.println("job");
    }

    @Override
    public void setPriority(int level) {
        // Implementation of the setPriority method
        this.priority = level;
    }

    @Override
    public int getPriority() {
        // Implementation of the getPriority method
        return this.priority;
    }
}
