public class Test4 {
    private static int count=10;
    //synchronized 关键字
    public static void main(String[] args) {
        synchronized (Test4.class){
            count--;
        }
        System.out.println(count);
    }
}
