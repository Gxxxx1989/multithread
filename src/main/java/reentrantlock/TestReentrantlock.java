package reentrantlock;

import sun.text.resources.cldr.ti.FormatData_ti;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁 lock.tryLock 可以申请锁的时间 拿不到进行下一步处理
 *只有拿到锁才需要释放
 * synchronized 一旦进入等待 必须使用wait方法才能醒过来
 * @author guoxi_789@126.com
 * @date 2020/11/10
 */
public class TestReentrantlock {
    Lock lock = new ReentrantLock();

    public void m1() {
        System.out.println("m1 start...");
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        boolean b = false;
        try {
            b = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2 start... " + b);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (b) {
                //只有拿到锁才需要释放
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        TestReentrantlock testReentrantlock = new TestReentrantlock();
        new Thread(testReentrantlock::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(testReentrantlock::m2).start();
    }
}