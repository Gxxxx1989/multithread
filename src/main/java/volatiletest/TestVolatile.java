package volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字，保证内存可见，禁止指令重排，不保证原子性
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestVolatile {
    volatile boolean running = true;

    public void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();

        new Thread(testVolatile::m, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testVolatile.m();
            }
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testVolatile.running = false;
    }
    
}
