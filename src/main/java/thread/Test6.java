package thread;

/**
 * 
 * 加锁方法和没加锁方法可以同时运行 避免脏读的方式同时加上synchronized
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class Test6 {

    private String name;
    private double balance=111;

    public synchronized void  set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public  double getBalance(){
        synchronized (this){
            return this.balance;
        }
    }

    public static void main(String[] args) {
        Test6 test6=new Test6();
        new Thread(()-> test6.set("1",100)).start();
        System.out.println(test6.getBalance());
        new Thread(test6::getBalance).start();
        System.out.println(test6.getBalance());
    }
}
