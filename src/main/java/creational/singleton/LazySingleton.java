package creational.singleton;

/**
 * 懒加载，但线程不安全，当大量线程同时getInstance，而内存中没有时，不再是单例
 * 所以需要加锁：双重检查所Double Check Lock
 */
public class LazySingleton {
    /*
    没有使用final关键字来修饰instance变量的原因是懒汉式单例模式存在线程安全性问题，也是为了允许后续对instance进行修改。
    如果使用final关键字来修饰instance变量，那么一旦实例被创建并赋值给instance后，就无法再修改它的值。
    这就意味着无法在后续的调用中重新创建实例，违反了懒加载的原则。
     */
    private static LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (null == instance){
            instance = new LazySingleton();
        }
        return instance;
    }
}
