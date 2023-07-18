package org.example.designPatterns.structural.facade.express;

/**
 * 外部服务实现类2（申通送货）
 */
public class STExpress implements ExpressService{
    @Override
    public void deliver() {
        System.out.println("申通送货中");
    }
}
