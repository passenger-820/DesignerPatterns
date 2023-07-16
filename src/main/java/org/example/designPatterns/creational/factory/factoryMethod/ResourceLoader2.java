package org.example.designPatterns.creational.factory.factoryMethod;

import org.example.designPatterns.creational.factory.factoryMethod.factory.*;
import org.example.designPatterns.creational.factory.factoryMethod.factory.impl.ClasspathResourceFactory;
import org.example.designPatterns.creational.factory.factoryMethod.factory.impl.DefaultResourceFactory;
import org.example.designPatterns.creational.factory.factoryMethod.factory.impl.FileResourceFactory;
import org.example.designPatterns.creational.factory.factoryMethod.factory.impl.HttpResourceFactory;
import org.example.designPatterns.creational.factory.factoryMethod.product.AbstractResource;
import org.example.designPatterns.creational.factory.simpleFactory.ResourceLoadException;

import java.util.HashMap;
import java.util.Map;

public class ResourceLoader2 {
    //使用hashmap做工厂缓存
    private static Map<String, IResourceFactory> resourceFactoryCache = new HashMap<>(8);

    //利用静态代码块提前缓存
    //当然这也是hard coding，真相脱离代码，可以使用配置文件，见版本3
    static {
        resourceFactoryCache.put("http",new HttpResourceFactory());
        resourceFactoryCache.put("file",new FileResourceFactory());
        resourceFactoryCache.put("classpath",new ClasspathResourceFactory());
        resourceFactoryCache.put("default",new DefaultResourceFactory());
    }

    public AbstractResource load(String url){
        String type = getResourcePrefix(url);
        //从缓存拿到工厂，再创建产品
        return resourceFactoryCache.get(type).create(url);

    }

    private String getResourcePrefix(String url){
        if (null == url || "".equals(url) || !url.contains(":")){
            throw new ResourceLoadException("url illegal");
        }
        String[] split = url.split(":");
        return split[0];
    }
}
