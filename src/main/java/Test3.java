
/**
 * join方法 控制线程执行顺序  t3里调用t2.join() 等待t2线程执行完毕在执行t3线程
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class Test3 implements Runnable{
    static Thread t2 =null;
    @Override
    public void run() {
        //Thread.currentThread().sleep(1000);
        //Thread.currentThread().join();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        t2=new Thread(new Test2(), "线程2");
        t2.start();
        Thread t3 = new Thread(new Test3(), "线程3");
        t3.start();
    }
}
