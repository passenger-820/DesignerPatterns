package factory.factoryMethod.factory.impl;


import factory.factoryMethod.factory.IResourceFactory;
import factory.factoryMethod.product.AbstractResource;
import factory.factoryMethod.product.impl.ClasspathResource;

public class ClasspathResourceFactory implements IResourceFactory {
    @Override
    public AbstractResource create(String url) {
        // 中间省略复杂的创建过程
        return new ClasspathResource(url);
    }
}
