package org.example.designPatterns.creational.factory.abstractFactory.product.impl;

import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractVideoIResource;

import java.io.InputStream;

public class HttpVideoResource extends AbstractVideoIResource {
    public HttpVideoResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return super.getInputStream();
    }

    public HttpVideoResource() {
        super();
    }
}
