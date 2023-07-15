package creational.factory.abstractFactory.factory.impl;

import creational.factory.abstractFactory.factory.AbstractResourceFactory;
import creational.factory.abstractFactory.product.AbstractTextIResource;
import creational.factory.abstractFactory.product.AbstractVideoIResource;
import creational.factory.abstractFactory.product.impl.HttpTextResource;
import creational.factory.abstractFactory.product.impl.HttpVideoResource;

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
