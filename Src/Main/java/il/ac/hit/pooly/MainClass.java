package il.ac.hit.pooly;
import javax.print.attribute.standard.JobPriority;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

class Job implements Runnable {
    private String jobName;
    private JobPriority1 jobPriority;

    public Job(String jobName, JobPriority1 jobPriority)
    {
        this.jobName = jobName;
        this.jobPriority = jobPriority;
    }
    @Override
    public void run() {
        System.out.println("Job:" + jobName +
                " Priority:" + jobPriority);
        try {
            Thread.sleep(1000); // to simulate actual execution time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public JobPriority1 getJobPriority() {
        return jobPriority;
    }
    // standard setters and getters
}

enum JobPriority1 {
    HIGH,
    MEDIUM,
    LOW
}
public class MainClass {
    public static void main(String[] args) {
        int POOL_SIZE = 10;
        int QUEUE_SIZE = 20;

        Job job1 = new Job("Job1", JobPriority1.LOW);
        Job job2 = new Job("Job2", JobPriority1.MEDIUM);
        Job job3 = new Job("Job3", JobPriority1.LOW);
        Job job4 = new Job("Job4", JobPriority1.MEDIUM);
        Job job5 = new Job("Job5", JobPriority1.LOW);
        Job job6 = new Job("Job6", JobPriority1.HIGH);
        Job job7 = new Job("Job7", JobPriority1.LOW);
        Job job8 = new Job("Job8", JobPriority1.HIGH);
        Job job9 = new Job("Job9", JobPriority1.MEDIUM);
        Job job10 = new Job("Job10", JobPriority1.HIGH);
        Job job11 = new Job("Job11", JobPriority1.MEDIUM);
        Job job12 = new Job("Job12", JobPriority1.LOW);
        Job job13 = new Job("Job13", JobPriority1.HIGH);
        Job job14 = new Job("Job14", JobPriority1.HIGH);


        PriorityJobScheduler pjs = new PriorityJobScheduler(
                POOL_SIZE, QUEUE_SIZE);

        pjs.scheduleJob(job1);
        pjs.scheduleJob(job2);
        pjs.scheduleJob(job3);
        pjs.scheduleJob(job4);
        pjs.scheduleJob(job5);
        pjs.scheduleJob(job6);
        pjs.scheduleJob(job7);
        pjs.scheduleJob(job8);
        pjs.scheduleJob(job9);
        pjs.scheduleJob(job10);
        pjs.scheduleJob(job11);
        pjs.scheduleJob(job12);
        pjs.scheduleJob(job13);
        pjs.scheduleJob(job14);

        // clean up
    }
}
/*
public class MainClass {
    public static void main(String[] args) {
        ThreadsPool threadsPool = new ThreadsPool(5);

        for (int i = 0; i < 100; ++i) {
            Task task = new TaskImpl(i);
            threadsPool.submit(task);
        }

//        // Give threads some time to execute tasks before shutting down
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        threadsPool.shutdown();
    }
}
*/