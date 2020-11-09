package volatiletest;

/**
 * 锁优化 尽量锁定更小的代码块
 * 如果很多小的加锁的代码块 可以用一个方法锁
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestVolatile3 {
    private int count = 0;

    public synchronized void m() {

        try {

        } catch (Exception e) {
        }
        count++;
        try {

        } catch (Exception e) {
        }
    }

    public void m1() {

        try {

        } catch (Exception e) {
        }
        synchronized (this) {
            count++;
        }
        try {

        } catch (Exception e) {
        }
    }
}
