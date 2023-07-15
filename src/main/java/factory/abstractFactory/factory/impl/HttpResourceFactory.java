package factory.abstractFactory.factory.impl;

import factory.abstractFactory.factory.AbstractResourceFactory;
import factory.abstractFactory.product.AbstractTextIResource;
import factory.abstractFactory.product.AbstractVideoIResource;
import factory.abstractFactory.product.impl.HttpTextResource;
import factory.abstractFactory.product.impl.HttpVideoResource;

public class HttpResourceFactory extends AbstractResourceFactory {
    @Override
    public AbstractTextIResource createTextResource(String url) {
        return new HttpTextResource(url);
    }

    @Override
    public AbstractVideoIResource createVideoResource(String url) {
        return new HttpVideoResource(url);
    }
}
