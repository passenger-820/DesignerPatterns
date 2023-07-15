package factory.factoryMethod.product.impl;

import factory.factoryMethod.product.AbstractResource;

import java.io.InputStream;

public class HttpResource extends AbstractResource {
    public HttpResource() {
    }

    public HttpResource(String url) {
        super(url);
    }
    @Override
    public InputStream getInputStream() {
        return null;
    }
}
