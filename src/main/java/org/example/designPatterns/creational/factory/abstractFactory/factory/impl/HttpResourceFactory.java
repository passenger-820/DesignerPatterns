package org.example.designPatterns.creational.factory.abstractFactory.factory.impl;

import org.example.designPatterns.creational.factory.abstractFactory.factory.AbstractResourceFactory;
import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractTextIResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractVideoIResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.impl.HttpTextResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.impl.HttpVideoResource;

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
