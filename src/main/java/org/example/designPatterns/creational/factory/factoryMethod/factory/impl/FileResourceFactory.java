package org.example.designPatterns.creational.factory.factoryMethod.factory.impl;


import org.example.designPatterns.creational.factory.factoryMethod.factory.IResourceFactory;
import org.example.designPatterns.creational.factory.factoryMethod.product.AbstractResource;
import org.example.designPatterns.creational.factory.factoryMethod.product.impl.FileResource;

public class FileResourceFactory implements IResourceFactory {
    @Override
    public AbstractResource create(String url) {
        // 中间省略复杂的创建过程
        return new FileResource(url);
    }
}
