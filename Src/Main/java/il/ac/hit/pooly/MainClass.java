package il.ac.hit.pooly;

public class MainClass {
    public static void main(String[] args) {
        ThreadsPool threadsPool = new ThreadsPool(5);

        for (int i = 0; i < 100; ++i) {
            Task task = new TaskImpl(i);
            threadsPool.submit(task);
        }

        // Give threads some time to execute tasks before shutting down
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadsPool.shutdown();
    }
}
