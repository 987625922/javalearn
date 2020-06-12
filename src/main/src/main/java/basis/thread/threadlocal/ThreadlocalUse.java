package basis.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 每一个Thread都单独维护了一个ThreadLocal，然后这个ThreadLocal又维护
 * 着一个ThreadLocalMap,设置数据的时候Key为Thread当前对象，value是
 * 我们设置的值
 */
public class ThreadlocalUse {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.execute(() -> {
                threadLocal.set(1);
            });
        }

    }

}
