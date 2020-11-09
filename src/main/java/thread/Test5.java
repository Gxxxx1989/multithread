package thread;

/**
 * 
 * synchronized 不能影响其他程序执行
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */

public class Test5 {
    public static void main(String[] args) {
        Test5 test5=new Test5();
        new Thread(test5::m1,"t1").start();
        new Thread(test5::m2,"t2").start();

    }
    public synchronized void m1(){
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    public void m2(){
        System.out.println("m2 start");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");
        
    }
}
