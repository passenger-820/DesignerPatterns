package factory.abstractFactory.factory;

import factory.abstractFactory.product.AbstractTextIResource;
import factory.abstractFactory.product.AbstractVideoIResource;

public class AbstractResourceFactory implements IResourceFactory{

    @Override
    public AbstractVideoIResource createVideoResource(String url) {
        return null;
    }

    @Override
    public AbstractTextIResource createTextResource(String url) {
        return null;
    }
}
