package thread;

/**
 * 线程通过实现Runnable接口实现
 *
 * @author guoxi_789@126.com
 * @date 2020/11/8
 */
public class Test2 implements Runnable{
    @Override
    public void run() {
        Thread.currentThread().setName("线程2");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new Test2(),"1").start();
    }
}
