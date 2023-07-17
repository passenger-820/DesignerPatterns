package org.example.designPatterns.behavioral.chain.linked;

public class Main {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.doHandle(new Request());
    }
}
