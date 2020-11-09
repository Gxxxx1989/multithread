package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁 lock.tryLock 可以申请锁的时间 拿不到进行下一步处理
 * 只有拿到锁才需要释放
 * synchronized 一旦进入等待 必须使用wait方法才能醒过来
 *
 * lock.lockInterruptibly() 可以打断
 *
 * @author guoxi_789@126.com
 * @date 2020/11/10
 */
public class TestReentrantlock2 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        TestReentrantlock2 testReentrantlock2 = new TestReentrantlock2();
        Thread t1 = new Thread(() -> {
            System.out.println("m1 start...");
            lock.lock();
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("m2 start...");
            }catch (InterruptedException e){
                System.out.println("InterruptedException...");
            }finally {
                //必须持有锁才能释放锁
                lock.unlock();
            }

            System.out.println("m2 start...");
        });


        t2.start();
        t2.interrupt();
        System.out.println("m2 end ...");
    }

}