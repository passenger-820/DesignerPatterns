package factory.abstractFactory.product;

import java.io.InputStream;

//改用接口做顶层设计，均需实现变成流的方法
//于是可以针对不同族群的产品，设定不同的抽象类
public interface IResource {
    InputStream getInputStream();
}
