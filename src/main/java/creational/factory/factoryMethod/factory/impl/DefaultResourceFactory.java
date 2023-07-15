package creational.factory.factoryMethod.factory.impl;


import creational.factory.factoryMethod.factory.IResourceFactory;
import creational.factory.factoryMethod.product.AbstractResource;
import creational.factory.factoryMethod.product.impl.DefaultResource;

public class DefaultResourceFactory implements IResourceFactory {
    @Override
    public AbstractResource create(String url) {
        // 中间省略复杂的创建过程
        return new DefaultResource(url);
    }
}
