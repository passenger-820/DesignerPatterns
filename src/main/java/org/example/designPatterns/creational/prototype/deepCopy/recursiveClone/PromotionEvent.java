package org.example.designPatterns.creational.prototype.deepCopy.recursiveClone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//促销活动
public class PromotionEvent implements Cloneable{
    private String name;
    private Date startDate;
    private Date endDate;
    private List<PromotionRule> rules;

    @Override
    protected PromotionEvent clone(){
        try {
            //先把自己浅拷贝了
            PromotionEvent newEvent = (PromotionEvent) super.clone();
            //克隆里面所有非基础数据类，Date是引用类型
//            newEvent.startDate= (Date) startDate.clone();
            /*
            使用set方法进行赋值的方式更加安全和灵活，因为它允许在属性赋值的过程中进行必要的逻辑操作。
            而直接使用.进行赋值更加简洁，但可能会绕过一些额外的逻辑
             */
            newEvent.setStartDate((Date) startDate.clone());
            newEvent.endDate= (Date) endDate.clone();
            //需要一个新的promotionRules
            newEvent.rules = new ArrayList<>();
            //遍历原有的促销策略
            for (PromotionRule rule : rules) {
                //将原有的促销策略拷贝到当前促销活动的促销策略中
                newEvent.rules.add(rule.clone()); //rule的克隆是已经实现了对product的拷贝
            }
            //返回自己
            return newEvent;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
