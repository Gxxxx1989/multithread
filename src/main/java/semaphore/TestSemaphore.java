package semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量 限流 （最多允许多少线程运行）
 *
 * @author guoxi_789@126.com
 * @date 2020/11/10
 */
public class TestSemaphore {
    /**
     * 允许一个线程同时执行
     */


    public static void main(String[] args) {
        //Semaphore semaphore = new Semaphore(2);
        //设置是否为公平锁
        Semaphore semaphore = new Semaphore(2,true);
        new Thread(() -> {
            try {
                //阻塞方法 取到就会-1
                semaphore.acquire();
                System.out.println("T1 running...");
                Thread.sleep(1000);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放信号量 信号量又会+1
                semaphore.release();
            }
        }).start();

        new Thread(() -> {
            try {
                //阻塞方法 取到就会-1
                semaphore.acquire();
                System.out.println("T2 running...");
                Thread.sleep(1000);
                System.out.println("T2 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放信号量 信号量又会+1
                semaphore.release();
            }
        }).start();
    }

}
