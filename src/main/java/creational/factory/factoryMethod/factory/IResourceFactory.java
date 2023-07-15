package creational.factory.factoryMethod.factory;


import creational.factory.factoryMethod.product.AbstractResource;

/**
 * 将工厂抽象化，需要哪种来源的工厂，就实例化该工厂
 */
public interface IResourceFactory {
    AbstractResource create(String url);
}
