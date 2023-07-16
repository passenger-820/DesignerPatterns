package org.example.designPatterns.creational.factory.abstractFactory.product.impl;

import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractVideoIResource;

import java.io.InputStream;

public class DefaultVideoResource extends AbstractVideoIResource {
    public DefaultVideoResource() {
        super();
    }

    public DefaultVideoResource(String url) {
    }

    @Override
    public InputStream getInputStream() {
        return super.getInputStream();
    }
}
