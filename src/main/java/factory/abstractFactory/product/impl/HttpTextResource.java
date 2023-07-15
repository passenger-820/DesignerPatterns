package factory.abstractFactory.product.impl;

import factory.abstractFactory.product.AbstractTextIResource;

import java.io.InputStream;

public class HttpTextResource extends AbstractTextIResource {
    public HttpTextResource(String url) {
    }

    public HttpTextResource() {
        super();
    }

    @Override
    public InputStream getInputStream() {
        return super.getInputStream();
    }
}
