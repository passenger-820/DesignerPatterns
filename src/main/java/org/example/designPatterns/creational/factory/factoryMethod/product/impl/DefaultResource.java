package org.example.designPatterns.creational.factory.factoryMethod.product.impl;

import org.example.designPatterns.creational.factory.factoryMethod.product.AbstractResource;

import java.io.InputStream;

public class DefaultResource extends AbstractResource {

    public DefaultResource() {
    }

    public DefaultResource(String url) {
        super(url);
    }
    @Override
    public InputStream getInputStream() {
        return null;
    }
}
