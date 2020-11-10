package exchanger;

import java.util.concurrent.Exchanger;

/**
 * 线程通信 交换数据
 *
 * @author guoxi_789@126.com
 * @date 2020/11/10
 */
public class Testexchanger {


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String s = "T1";
            try {
                s=exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + s);
        }, "t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                s=exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + s);
        }, "t2").start();
    }
}
