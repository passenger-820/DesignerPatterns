package org.example.designPatterns.creational.prototype.deepCopy.recursiveClone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//产品
public class Product implements Cloneable{
    private String name;
    private double price;
    private int stock;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
