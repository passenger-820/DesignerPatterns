package org.example.designPatterns.behavioral.chain.linked;

import java.util.LinkedList;

/**
 * 抽象处理器，本例基于单链表，且所有处理器都处理一遍请求
 */
public abstract class Handler {
    //维护一个子节点
    protected Handler next;

    //设置子节点
    public void setNext(Handler next){
        this.next = next;
    }

    //抽象方法，子类实现，处理请求
    public abstract void handle(Request request);
}
