package volatiletest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字，保证内存可见，禁止指令重排，不保证原子性
 *  count++ 不是原子操作，要使用锁才能保证原子性
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestVolatile2 {
    volatile int count = 0;

    public synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        TestVolatile2 testVolatile2 = new TestVolatile2();

        Collection<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(testVolatile2::m, "thread" + i));
        }

        //1、
        threads.forEach(thread -> {
            thread.start();
        });
        //2、
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(testVolatile2.count);
    }
}
