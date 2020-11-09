package cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * JDK 提供的线程安全的操作 必须使用线程的join方法
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestAtomic {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void m() {
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();//count ++
        }
    }

    public static void main(String[] args) {
        TestAtomic testAtomic = new TestAtomic();

        List<Thread> threads = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(testAtomic::m));
        }

        threads.forEach(thread -> {
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(testAtomic.atomicInteger);
    }
}
