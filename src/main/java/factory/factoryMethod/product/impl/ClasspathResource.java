package factory.factoryMethod.product.impl;

import factory.factoryMethod.product.AbstractResource;

import java.io.InputStream;
//其他产品同理，都要继承抽象类
//同时IResourceFactory里面Resource变AbstractResource，对应的实现类也要做改变
//这就是解耦
public class ClasspathResource extends AbstractResource {

    public ClasspathResource() {
    }

    public ClasspathResource(String url) {
        super(url);
    }
    @Override
    public InputStream getInputStream() {
        return null;
    }
}
