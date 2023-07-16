package org.example.designPatterns.creational.factory.factoryMethod;

import org.example.designPatterns.creational.factory.factoryMethod.factory.IResourceFactory;
import org.example.designPatterns.creational.factory.factoryMethod.product.AbstractResource;
import org.example.designPatterns.creational.factory.simpleFactory.ResourceLoadException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ResourceLoader3 {
    //使用hashmap做工厂缓存
    private static Map<String, IResourceFactory> resourceFactoryCache = new HashMap<>(8);

    // 1、完全满足开闭原则
    // 问：缓存资源可以吗？对于简单工厂模式，缓存资源（产品）一般是不行的(spring里面有beanFactory，
    // 缓存了资源)，因为资源是从文件或者网络加载出来的，每次都不一样；
    // 问：如果每次加载的资源都一样，有必要缓存资源吗？可以是可以，但是资源可能很复杂，
    // 缓存起来耗时且占用资源；缓存工厂是可以的，工厂无状态，只负责创建；创建一个resource的过程要远比创建一个工厂复杂；
    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("resourceFactory.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            for (Map.Entry<Object,Object> entry : properties.entrySet()){
                String key = entry.getKey().toString();
                Class<?> clazz = Class.forName(entry.getValue().toString());
                IResourceFactory factory = (IResourceFactory) clazz.getConstructor().newInstance();
                resourceFactoryCache.put(key,factory);
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
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

    public static void main(String[] args) {
        ResourceLoader3 resourceLoader3 = new ResourceLoader3();
        AbstractResource resource = resourceLoader3.load("http://123.com");
        System.out.println(resource);
    }
}
