package singleton;

/**
 * 饿汉式
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestSingleton {
    private static final TestSingleton instance = new TestSingleton();

    private TestSingleton() {
    }

    public static TestSingleton getInstance() {
        return instance;
    }
}
