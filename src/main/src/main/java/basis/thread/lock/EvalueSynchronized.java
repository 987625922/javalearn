package basis.thread.lock;


/**
 * synchrobized给方法加锁，只有持有锁的线程可以操作，
 * synchronized 保证线程的可见性和有序性
 * Object.wait()和Object.notify()是和synchronized配合使用的
 */
public class EvalueSynchronized {

    //volatile 不能保证线程安全，只能确保数据修改后，其他线程能看到这个改动
    static volatile int synchrobizedMun = 0;

    //给方法加锁，只有持有锁的线程可以操作，
    // synchronized 保证线程的可见性和有序性
    public synchronized static void synchrobizedMunIncrease() {
        synchrobizedMun++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchrobizedMunIncrease();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchrobizedMunIncrease();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(synchrobizedMun);
    }
}
