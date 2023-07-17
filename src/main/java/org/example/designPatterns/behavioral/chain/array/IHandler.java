package org.example.designPatterns.behavioral.chain.array;

/**
 * 不必维护子节点。所以就用接口，只需实现方法即可
 * 这里使标准的责任链模式，即判断是否需要处理请求，再执行队形操作
 */
public interface IHandler {
    boolean handle(Request request);
}
