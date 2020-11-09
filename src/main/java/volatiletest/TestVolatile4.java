package volatiletest;

import java.util.TreeMap;

/**
 * 锁的对象发生变化
 * 因为请求的是对象头上的 MarkWord 前两位，所以对象发生变化MarkWord也相应不一致 所以会产生问题
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestVolatile4 {
    final Object o = new Object();

    public void m() {
        synchronized (o) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        TestVolatile4 testVolatile4 = new TestVolatile4();
        new Thread(testVolatile4::m,"1").start();

        Thread thread2 = new Thread(testVolatile4::m,"2");
        //testVolatile4.o = new Object();
        thread2.start();
    }
}
