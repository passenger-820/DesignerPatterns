package factory.factoryMethod.product;

import java.io.InputStream;
//我们的代码中产品是简单单一的类，事实上，在工作中，我们的产品可能是极其复杂的，
// 不应当在抽象的工厂中生产具体的Resource，而是要把Resource也抽象化为
// AbstractResource，我们同样需要对整个产品线进行抽象。
// 一般来说，用Interface可以的，但是如果产品里面有一些共享方法、共享变量、
// 共享构造器、默认方法，但是放接口里面，不符合java里面的面向对象语义，不妨将它定义为抽象类
public abstract class AbstractResource {
    // 共享变量
    private String url;

    public AbstractResource(){}
    // 共享构造器
    public AbstractResource(String url) {
        this.url = url;
    }

    // 共享方法，此处protected限制只让子类使用
    protected void shared(){
        System.out.println("这是共享方法");
    }

    /**
     * 每个子类需要独自实现的抽象方法
     * @return 字节流
     */
    public abstract InputStream getInputStream();
}
