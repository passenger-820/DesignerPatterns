package org.example.designPatterns.creational.factory.abstractFactory.factory.impl;

import org.example.designPatterns.creational.factory.abstractFactory.factory.AbstractResourceFactory;
import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractTextIResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractVideoIResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.impl.DefaultTextResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.impl.DefaultVideoResource;

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
