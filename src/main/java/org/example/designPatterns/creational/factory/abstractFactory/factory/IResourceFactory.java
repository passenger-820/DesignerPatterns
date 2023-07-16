package org.example.designPatterns.creational.factory.abstractFactory.factory;

import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractTextIResource;
import org.example.designPatterns.creational.factory.abstractFactory.product.AbstractVideoIResource;

//一个工厂可以生产一个产品族
public interface IResourceFactory {

    /**
     * 加载视频资源的工厂方法
     * @param url 给定的资源url
     * @return 视频资源
     */
    AbstractVideoIResource createVideoResource(String url);

    /**
     * 加载文本资源的工厂方法
     * @param url 给定的资源url
     * @return 文本资源
     */
    AbstractTextIResource createTextResource(String url);
}
