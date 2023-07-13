package creational.singleton;

/**
 * 让静态内部类持有单例，加载时即初始化单例
 * 暴露的方法通过内部类获取单例
 */
public class InnerSingleton {
    //不用自己在这边持有一个instance变量

    //私有化构造器
    private InnerSingleton(){}

    //由静态内部类实例化外部类
    private static class InnerSingletonHolder{
        //final确保该变量在实例化后不会被再次修改。
        //这样就能保证InnerSingleton类的单例对象始终只有一个，并且在调用getInstance方法时能够返回同一个实例
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }

    public InnerSingleton getInstance(){
        return InnerSingletonHolder.INSTANCE;
    }
}
