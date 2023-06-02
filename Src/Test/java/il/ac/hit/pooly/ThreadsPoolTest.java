package il.ac.hit.pooly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsPoolTest {
    @Test
    void testSubmit() {
        ThreadsPool pool = new ThreadsPool(3);

        Task task = new Task() {
            private int priority;

            @Override
            public void perform() {
                System.out.println("Task performed with priority: " + priority);
            }

            @Override
            public void setPriority(int level) {
                this.priority = level;
            }

            @Override
            public int getPriority() {
                return this.priority;
            }
        };

        task.setPriority(1);


        task.setPriority(3);

        task.setPriority(2);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);

    }
}
