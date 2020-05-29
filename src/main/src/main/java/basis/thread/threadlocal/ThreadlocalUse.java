package basis.thread.threadlocal;

import java.util.concurrent.CountDownLatch;


public class ThreadlocalUse {

    public static void main(String[] args) throws InterruptedException {

        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("Threadlocal的使用");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();

    }

    private static class InnerClass {

        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
//            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
//                    Thread.currentThread().getName(),
//                    Counter.counter.hashCode(),
//                    Counter.counter.get().hashCode(),
//                    Counter.counter.get().toString());
        }
    }

    private static class Counter {
        /**
         * 如果下面的值不需要在线程中共享，就可以使用ThreadLocal让每个线程内部都会有一个该变量，且在线程内部任何地方都可以使用，
         * 线程之间互不影响，这样一来就不存在线程安全问题，也不会严重影响程序执行性能。
         * 但是由于在每个线程中都创建了副本，所以要考虑它对资源的消耗，比如内存的占用会比不使用ThreadLocal要大。
         * 原理使用了Map的方法，在每个线程Thread内部有一个ThreadLocal.ThreadLocalMap类型的成员变量threadLocals，
         * 这个threadLocals就是用来存储实际的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。
         * 初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，
         * 就会对Thread类中的threadLocals进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。
         * 然后在当前线程里面，如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
         */
        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };

    }

}
