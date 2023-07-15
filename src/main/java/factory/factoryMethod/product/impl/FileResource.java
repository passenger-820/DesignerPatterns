package factory.factoryMethod.product.impl;

import factory.factoryMethod.product.AbstractResource;

import java.io.InputStream;

public class FileResource extends AbstractResource {
    public FileResource() {
    }

    public FileResource(String url) {
        super(url);
    }
    @Override
    public InputStream getInputStream() {
        return null;
    }

}
