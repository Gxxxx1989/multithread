package readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁和排他锁
 *
 * @author guoxi_789@126.com
 * @date 2020/11/10
 */
public class TestReadWriteLock {
    static Lock lock = new ReentrantLock();

    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void readLock(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("read over!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void writeLock(int value, Lock lock) {
        lock.lock();
        try {
            TestReadWriteLock.value = value;
            Thread.sleep(1000);
            System.out.println("write over!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        Runnable runnable = () -> readLock(lock);
        Runnable runnable = () -> readLock(readLock);
        for (int i = 0; i < 14; i++) {
            new Thread(runnable).start();
        }


//        Runnable runnable1 = () -> writeLock(1,lock);
        Runnable runnable1 = () -> writeLock(1, writeLock);
        for (int i = 0; i < 5; i++) {
            new Thread(runnable1).start();
        }
    }
}
