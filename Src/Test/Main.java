import il.ac.hit.pooly.Task;
import il.ac.hit.pooly.ThreadPoolException;
import il.ac.hit.pooly.ThreadsPool;

public class Main {
    public static void main(String[] args) {
        int poolSize = 2;

        try {
            ThreadsPool pjs = new ThreadsPool(poolSize);

            Task job1 = new Job(4);
            Task job2 = new Job(5);
            Task job3 = new Job(1);
            Task job4 = new Job(6);
            Task job5 = new Job(2);
            Task job6 = new Job(17);
            Task job7 = new Job(4);
            Task job8 = new Job(20);
            Task job9 = new Job(-13);
            Task job10 = new Job(15);

            pjs.submit(job1);
            pjs.submit(job2);
            pjs.submit(job3);
            pjs.submit(job4);
            pjs.submit(job5);
            pjs.submit(job6);
            pjs.submit(job7);
            pjs.submit(job8);
            pjs.submit(job9);
            pjs.submit(job10);


            pjs.shutdown();
        } catch (ThreadPoolException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

