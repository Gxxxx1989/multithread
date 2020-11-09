package thread;

/**
 * synchronized 可重入概念  A方法调用B方法的时候 A用synchronized 修饰，B同样用synchronized修饰，
 * 允许B用synchronized修饰的现象叫做可重入锁，否则产生死锁
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class Test7 {
    public synchronized void m1(){
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }
    public  synchronized void m2(){
        System.out.println("m2 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");

    }

    public static void main(String[] args) {
        new Thread(new Test7()::m1).start();
    }
}
