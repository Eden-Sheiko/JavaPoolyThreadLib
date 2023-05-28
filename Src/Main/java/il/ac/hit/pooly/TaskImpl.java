package il.ac.hit.pooly;

public class TaskImpl implements Task {
    private int priority;

    public TaskImpl(int priority){
        setPriority(priority);
    }

    public TaskImpl(){
        this(0);
    }

    @Override
    public void perform() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Performing task with priority: " + priority);
    }

    @Override
    public void setPriority(int level) {
        this.priority = level;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }
}