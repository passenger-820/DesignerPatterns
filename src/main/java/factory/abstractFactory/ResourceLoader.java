package factory.abstractFactory;

import factory.abstractFactory.factory.IResourceFactory;
import factory.abstractFactory.product.AbstractTextIResource;
import factory.abstractFactory.product.AbstractVideoIResource;
import factory.abstractFactory.product.IResource;
import factory.simpleFactory.ResourceLoadException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ResourceLoader {
    //使用hashmap做工厂缓存
    private static Map<String, IResourceFactory> resourceFactoryCache = new HashMap<>(8);

    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("resourceFactory2.properties");
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

    public List<IResource> load(String url){
        List<IResource> list = new ArrayList<>();
        String type = getResourcePrefix(url);
        //从缓存拿到工厂，再创建产品
        IResourceFactory factory = resourceFactoryCache.get(type);
        AbstractVideoIResource videoResource = factory.createVideoResource(url);
        list.add(videoResource);
        AbstractTextIResource textResource = factory.createTextResource(url);
        list.add(textResource);
        return list;

    }

    private String getResourcePrefix(String url){
        if (null == url || "".equals(url) || !url.contains(":")){
            throw new ResourceLoadException("url illegal");
        }
        String[] split = url.split(":");
        return split[0];
    }

    public static void main(String[] args) {
        ResourceLoader resourceLoader = new ResourceLoader();
        List<IResource> resources = resourceLoader.load("http://dff");
        for (IResource resource : resources) {
            System.out.println(resource);
        }
    }
}
