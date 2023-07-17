package org.example.designPatterns.behavioral.chain.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 按需处理请求
 */
public class HandlerChain {
    //数组
    List<IHandler> handlerChain = new ArrayList<>();

    //添加处理器
    public void addHandler(IHandler handler){
        handlerChain.add(handler);
    }
    //处理请求
    public void doHandle(Request request){
        //得有处理器才行
        if (handlerChain.size() == 0){
            return;
        }
        for (IHandler handler : handlerChain) {
            //让处理器处理
            boolean handled = handler.handle(request);
            //如果该处理器处理了，就返回true，则找到了第一个可以处理的处理器，提前结束循环
            //否则不处理，就是false，继续往后找
            if (handled){
                return;
            }
        }
    }
}
