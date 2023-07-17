package org.example.designPatterns.behavioral.chain.linked;

/**
 * 第一个处理器，处理一次
 */
public class HandlerA extends Handler{
    @Override
    public void handle(Request request) {
        //处理一次请求，已数值+1表示吧
        request.setNum(request.getNum()+1);
        System.out.println("A过滤器-->" +request.getNum());
    }
}
