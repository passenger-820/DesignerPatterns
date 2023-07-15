package creational.factory.abstractFactory.factory.impl;

import creational.factory.abstractFactory.factory.AbstractResourceFactory;
import creational.factory.abstractFactory.product.AbstractTextIResource;
import creational.factory.abstractFactory.product.AbstractVideoIResource;
import creational.factory.abstractFactory.product.impl.DefaultTextResource;
import creational.factory.abstractFactory.product.impl.DefaultVideoResource;

public class DefaultResourceFactory extends AbstractResourceFactory {
    @Override
    public AbstractVideoIResource createVideoResource(String url) {
        return new DefaultVideoResource(url);
    }

    @Override
    public AbstractTextIResource createTextResource(String url) {
        return new DefaultTextResource(url);
    }
}
