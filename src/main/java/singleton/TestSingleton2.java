package singleton;

/**
 * 懒汉式 线程不安全
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestSingleton2 {
    private static TestSingleton2 instance;

    private TestSingleton2() {
    }

    public static TestSingleton2 getInstance() {
        if (instance == null) {
            instance = new TestSingleton2();
        }
        return instance;
    }
}
