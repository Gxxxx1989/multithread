package singleton;

/**
 * 懒汉式 线程安全
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestSingleton3 {
    private static TestSingleton3 instance;

    private TestSingleton3() {
    }

    public static synchronized TestSingleton3 getInstance() {
        if (instance == null) {
            instance = new TestSingleton3();
        }
        return instance;
    }
}
