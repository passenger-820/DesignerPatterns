package org.example.designPatterns.creational.factory.abstractFactory.product;

import java.io.InputStream;

public abstract class AbstractVideoIResource implements IResource {
    private String url;


    public AbstractVideoIResource() {
    }

    public AbstractVideoIResource(String url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
