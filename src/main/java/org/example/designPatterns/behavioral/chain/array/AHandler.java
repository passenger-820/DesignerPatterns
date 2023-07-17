package org.example.designPatterns.behavioral.chain.array;

public class AHandler implements IHandler{
    @Override
    public boolean handle(Request request) {
        //需要判断是否需要自己处理
        if(request.getNum() > 5){
            request.setNum(request.getNum() + 1);
            System.out.println("A过滤器-->" +request.getNum());
            return true;
        }
        System.out.println("A过滤器-->" +request.getNum() + "-->我不处理");
        return false;
    }
}
