package creational.singleton;

public class DclSingleton {
    /*
    volatile如果不加可能会出现半初始化的对象
    现在用的高版本（1.9+）的 Java 已经在 JDK 内部实现中解决了这个问题
    解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序,为了兼容性我们加上
     */
    private volatile static DclSingleton instance;
    private DclSingleton(){}

    /**
     * 这里要解决并发问题：
     *     第一重检查，是为了提升性能：instance不为null时，后面的线程不要在里面再判断instance是不是null而考虑要不要new
     *     第二重检查，是为了实现单例：instance为null时，允许创建单例
     * @return 单例
     */
    public static DclSingleton getInstance(){
        if (null == instance){
            synchronized (DclSingleton.class){
                if (null == instance){
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }
}
