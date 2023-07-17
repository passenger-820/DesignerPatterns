package org.example.designPatterns.behavioral.chain.array;

public class Main {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new BHandler());
        handlerChain.addHandler(new BHandler());
        handlerChain.addHandler(new BHandler());
        handlerChain.addHandler(new BHandler());
        handlerChain.addHandler(new BHandler());
        handlerChain.addHandler(new AHandler());
        handlerChain.addHandler(new AHandler());

        handlerChain.doHandle(new Request(8));
    }
}
