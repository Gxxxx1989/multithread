import javafx.scene.input.TouchEvent;

/**
 * 线程通过继承Thread类实现
 * 需要重写run 方法
 *
 * @author guoxi_789@126.com
 * @date 2020/11/8
 */
public class Test1 extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        Test1 test1=new Test1();
        test1.start();
        System.out.println(Thread.currentThread().getName());
    }
}
