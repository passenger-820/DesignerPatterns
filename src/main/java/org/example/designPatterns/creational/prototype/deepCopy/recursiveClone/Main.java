package org.example.designPatterns.creational.prototype.deepCopy.recursiveClone;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //创建原始促销活动
        final PromotionEvent sourceEvent = createSamplePromotionEvent();
        System.out.println("sourceEvent.getRules().get(0).getDiscount() = " + sourceEvent.getRules().get(0).getDiscount());

        //创建新的促销活动
        PromotionEvent newEvent = sourceEvent.clone();

        //设置新的日期
        newEvent.setStartDate(addDays(sourceEvent.getStartDate(),7));
        newEvent.setEndDate(addDays(sourceEvent.getEndDate(),7));
        //设置新的促销策略
        newEvent.getRules().get(0).setDiscount(newEvent.getRules().get(0).getDiscount() * 100);
        System.out.println("newEvent.getRules().get(0).getDiscount() = " + newEvent.getRules().get(0).getDiscount());
    }

    private static PromotionEvent createSamplePromotionEvent() {
        // 创建示例促销活动
        List<PromotionRule> rules = Arrays.asList(
                new PromotionRule("折扣", 0.9, new Product("ss",99,50012)),
                new PromotionRule("满减", 50, new Product("bb",99,40013))
        );

        PromotionEvent event = new PromotionEvent("原始促销活动", new Date(), addDays(new Date(), 7),
                rules
        );
        return event;
    }

    private static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
