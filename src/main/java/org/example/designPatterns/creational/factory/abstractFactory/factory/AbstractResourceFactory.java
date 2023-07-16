package org.example.designPatterns.creational.factory.abstractFactory.factory;

import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractTextIResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractVideoIResource;

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
