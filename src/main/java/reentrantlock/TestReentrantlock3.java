package reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 公平锁 Lock lock = new ReentrantLock(true); 默认非公平锁
 *
 * @author guoxi_789@126.com
 * @date 2020/11/10
 */
public class TestReentrantlock3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
    }
}
