package creational.prototype.deepCopy.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//产品
public class Product implements Cloneable, Serializable {
    private String name;
    private double price;
    private int stock;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
