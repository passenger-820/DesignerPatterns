package org.example.designPatterns.structural.facade.express;

/**
 * 门面类（菜鸟驿站）
 */
public class ExpressFacade {
    // 能够让圆通或申通送货，这两家都在门面中，由门面向外暴露这两家的服务
    private STExpress stExpress;
    private YTExpress ytExpress;

    public ExpressFacade() {
        this.stExpress = new STExpress();
        this.ytExpress = new YTExpress();
    }

    public void deliverByST(){
        stExpress.deliver();
    }

    public void deliverByYT(){
        ytExpress.deliver();
    }
}
