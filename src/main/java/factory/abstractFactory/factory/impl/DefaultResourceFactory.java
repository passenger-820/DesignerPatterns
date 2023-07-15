package factory.abstractFactory.factory.impl;

import factory.abstractFactory.factory.AbstractResourceFactory;
import factory.abstractFactory.product.AbstractTextIResource;
import factory.abstractFactory.product.AbstractVideoIResource;
import factory.abstractFactory.product.impl.DefaultTextResource;
import factory.abstractFactory.product.impl.DefaultVideoResource;

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
