package org.example.designPatterns.structural.facade.express;

/**
 * 外部服务实现类1（圆通送货）
 */
public class YTExpress implements ExpressService{
    @Override
    public void deliver() {
        System.out.println("圆通送货中");
    }
}
