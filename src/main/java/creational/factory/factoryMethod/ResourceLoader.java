package creational.factory.factoryMethod;

import creational.factory.factoryMethod.factory.*;
import creational.factory.factoryMethod.factory.impl.ClasspathResourceFactory;
import creational.factory.factoryMethod.factory.impl.DefaultResourceFactory;
import creational.factory.factoryMethod.factory.impl.FileResourceFactory;
import creational.factory.factoryMethod.factory.impl.HttpResourceFactory;
import creational.factory.factoryMethod.product.AbstractResource;
import creational.factory.simpleFactory.ResourceLoadException;

public class ResourceLoader {
    private IResourceFactory resourceFactory;

    public AbstractResource load(String url){
        String type = getResourcePrefix(url);

        //根据前缀选择不同的工厂，生产独自的产品
        //这里依旧是hard coding了，记作版本一
        // 后面可以优化，比如版本2，使用工厂缓存
        if("http".equals(type)){
            resourceFactory = new HttpResourceFactory();
        } else if ("file".equals(type)) {
            resourceFactory = new FileResourceFactory();
        } else if ("classpath".equals(type)) {
            resourceFactory = new ClasspathResourceFactory();
        } else {
            resourceFactory = new DefaultResourceFactory();
        }
        return resourceFactory.create(url);
    }

    private String getResourcePrefix(String url){
        if (null == url || "".equals(url) || !url.contains(":")){
            throw new ResourceLoadException("url illegal");
        }
        String[] split = url.split(":");
        return split[0];
    }
}
