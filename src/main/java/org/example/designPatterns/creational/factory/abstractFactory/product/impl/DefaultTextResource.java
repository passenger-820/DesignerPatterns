package org.example.designPatterns.creational.factory.abstractFactory.product.impl;

import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractTextIResource;

import java.io.InputStream;

public class DefaultTextResource extends AbstractTextIResource {
    public DefaultTextResource() {
        super();
    }

    @Override
    public InputStream getInputStream() {
        return super.getInputStream();
    }

    public DefaultTextResource(String url) {
    }
}
