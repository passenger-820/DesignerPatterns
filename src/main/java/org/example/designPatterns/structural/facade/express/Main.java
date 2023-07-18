package org.example.designPatterns.structural.facade.express;

public class Main {
    public static void main(String[] args) {
        //菜鸟驿站开好了，申通圆通已入驻
        ExpressFacade expressFacade = new ExpressFacade();
        //直接让他们送货
        expressFacade.deliverByST();
        expressFacade.deliverByYT();
    }
}
