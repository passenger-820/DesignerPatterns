package org.example.designPatterns.creational.prototype.deepCopy.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 促销规则
public class PromotionRule implements Cloneable, Serializable {
    private String type;
    private double discount;
    private Product product;

    @Override
    protected PromotionRule clone(){
        try {
            //先使用浅拷贝，通过父类的的方法对本身做前拷贝
            PromotionRule rule = (PromotionRule) super.clone();
            //本类中存在对Product的引用，因此需要拷贝Product
            Product copyProduct = (Product) product.clone();
            //再把产品给到自己，完成深拷贝
            rule.setProduct(copyProduct);
            return rule;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }
}
