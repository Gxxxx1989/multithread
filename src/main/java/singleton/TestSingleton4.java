package singleton;

/**
 * 双重检查锁
 *
 * @author guoxi_789@126.com
 * @date 2020/11/9
 */
public class TestSingleton4 {
    private static volatile TestSingleton4 instance;

    private TestSingleton4() {
    }

    public static synchronized TestSingleton4 getInstance() {
        if (instance == null) {
            synchronized (TestSingleton4.class){
                if (instance==null){
                    instance = new TestSingleton4();
                }
            }

        }
        return instance;
    }
}
