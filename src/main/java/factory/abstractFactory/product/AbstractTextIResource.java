package factory.abstractFactory.product;

import java.io.InputStream;

public abstract class AbstractTextIResource implements IResource {
    private String url;


    public AbstractTextIResource() {
    }

    public AbstractTextIResource(String url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
