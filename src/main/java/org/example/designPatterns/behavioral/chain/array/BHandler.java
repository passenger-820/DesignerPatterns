package org.example.designPatterns.behavioral.chain.array;

public class BHandler implements IHandler{
    @Override
    public boolean handle(Request request) {
        //处理一次请求，已数值+1表示吧
        if (request.getNum()>300){
            request.setNum(request.getNum()+100);
            System.out.println("B过滤器-->" +request.getNum());
            return true;
        }
        System.out.println("B过滤器-->" +request.getNum() + "-->我不处理");
        return false;
    }
}
